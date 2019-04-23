## 超大数据量去重（10亿级别以上）

有10 亿个url，每个url大小小于56B，要求去重，内存只给你4G

思路：

1.首先将给定的url调用hash方法计算出对应的hash的value，在10亿的url中相同url必然有着相同的value。

2.将文件的hash table 放到第value%n台机器上。

3.value/n是机器上hash table的值。

将文件分布在多个机器上，这样要处理网路延时。假设有n台机器。
- 首先hash文件得到hash value v

- 将文件的hash table 放到第v%n 台机器上。

- v/n是机器上hash table的值。

分析：

将文件的url进行hash，得到值value，相同的url的文件具有相同的value，
所以会被分配到同一台机器v%n上。在同一台机器上的重复的url文件具有相同的value/n值，
如果出现了冲突，不同的url在同一台机器上也可能有相同的value/n值。
在每个机器上将value/n值作为key，url值作为value构成hash表进行去重。
最后将内存中去重后的hash表中的value值即url写入磁盘。合并磁盘中的各部分url文件，完成去重。



























