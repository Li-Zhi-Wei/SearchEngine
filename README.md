# 小型搜索引擎

前段时间复习数据结构，想要真正掌握还是要动手写代码，所以做了这个小型搜索引擎。
主要用来练习各种数据结构，所以自己写了一些底层工具，尽量少用API。

### 进度

已完成：

- 文件读写工具
- HTTP连接工具
- 日志记录工具
- 布隆过滤器
- 文件实现队列
- 内存队列
- 中心计数器
- 调用链
- AC自动机
- BM算法
- HTML内容提取器

进行中：
- Trie 树
- 爬虫线程
- 分析线程
- web服务器
- 分析线程

### 使用方法

（入口暂未实现）
- 直接运行，通过控制台交互
- 运行NIO和Socket实现的简易HTTP服务器，通过网页交互

### 实现思路

功能分为三部分：搜集网页数据、分析网页数据并生成索引、查询数据

**1、搜集网页数据**

首先设置若干个种子URL，放入URL队列。
然后不断从队列里获取URL，使用这些URL爬取网页。从爬取到的网页中提取URL放入队列。

**2、分析网页数据并生成索引**

分析爬取的网页，从中提取有用的信息，如网页的keyword、description等，再将信息进行分词，以统计出每一个URL里有哪些分词。
最后再进行倒排索引，生成每个词对应多个URL的索引。


**3、根据倒排索引的结果，快速查询结果。**

输入要查询的信息，将查询信息进行分词。

根据分词查找索引，即可快速找出所有匹配的URL信息。



**4、自定义的简易HTTP服务器**

使用Socket和NIO，自建一个简易的http服务器。实现浏览器使用搜索引擎的功能。

使用NIO的Select方法，使用非阻塞式IO处理请求。

根据请求内容，分别处理首页请求和查询请求，做对应的处理。

## 技术细节

### 爬虫

- 爬虫会不停地解析页面链接，将其放到队列中，考虑到队列长度会非常长，用一个存储在磁盘中的文件（links.bin）来作为广度优先搜索中的队列。

- 使用布隆过滤器进行网页判重，本项目中用 int 数组实现了布隆过滤器，用一个 int 整数表示位图中二进制位的下标，下标范围\[0,Integer.MAX_VALUE\]

- 将网页数据合并保存，避免文件过多的问题。当网页数据文件大小达到 1 GB 时，创建新的数据文件。

- 维护一个线程安全的中心计数器给生成网页编号。同时生成一个记录每个网页编号和对应网页文件中偏移位置的文件。


### 数据分析

- 首先使用AC自动机搜索\<script\>，\<css\>等无用代码段和其他 HTML 标签，并去除他们。

- 使用清华大学开放中文词库作为单词表构造 Trie 树，使用最长匹配规则对网页字符串进行分词

- 使用中心计数器对单词进行编号，使用散列表记录遍过号的单词，将单词与网页对应关系写入临时索引文件。将单词与编号的对应关系写入文件中。

- 使用多路归并排序算法对临时索引文件按单词号进行排序，再遍历生成倒排索引文件。同时记录单词编号在倒排索引文件中的偏移位置。

倒排索引结果如下所示:

```
8[1,2,3]   //词为8，所对应的URL为1,2,3。
```

###  查询

- 网页编号和网页文件偏移位置的对应关系、单词和编号之间的对应关系、单词编号在倒排索引中的偏移位置的对应关系，这三个文件比较小，先以散列表的形式加载到内存中。

- 对输入的搜索字符串进行分词，使用 Trie 树和最长匹配规则进行分词。

- 用搜索词查找单词编号，用单词编号查找倒排索引，对得到的网页编号进行统计排序，再到网页文件中读取网页数据。
