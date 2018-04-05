##Session缓存   增删改查以及其他操作

1.在hibernate中使用c3p0数据源
	注意数据库和java类型的对应关系

1).导入jar包
	F:\Lib_javalib\hibernate-release-4.2.4.Final\lib\optional\c3p0\*.jar

2).加入配置
hibernate.c3p0.max_size:	数据库连接池的最大连接数
hibernate.c3p0.min_size:	数据库连接池的最小连接数
hibernate.c3p0.acquire_increment:	当前连接池中的连接耗尽时，同一时刻获取多少个数据连接

hibernate.c3p0.tomeout:	数据库连接池中连接对象在多长时间没有使用过后，就应该被销毁
hibernate.c3p0.idle_test_period:	表示连接池检测线程多长时间检测一次池内的所有连接对象是否超时，这个连接池本身不会把自己从连接池中移除，而是专门有一个线程按照一定的时间间隔来做这件事，这个线程通过比较连接对象最后一次使用时间和当前时间的时间差来和timeout 做对比，进而决定是否销毁这个连接对象。

hibernate.c3p0.max_statements:	缓存Statement 对象的数量