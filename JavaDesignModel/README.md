文章链接http://blog.csdn.net/zhangerqing/article/details/8194653
#Java设计模式
##一、设计模式的分类
	总体来说设计模式分为三大类：
	创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
	结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
	行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
	
##二、设计模式的六大原则
	1、开闭原则（Open Close Principle）
	开闭原则就是说对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。所以一句话概括就是：为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类，后面的具体设计中我们会提到这点。
	2、里氏代换原则（Liskov Substitution Principle）
	里 氏代换原则(Liskov Substitution Principle LSP)面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。 LSP是继承复用的基石，只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。里 氏代换原则是对“开-闭”原则的补充。实现“开-闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现 抽象化的具体步骤的规范。—— From Baidu 百科
	3、依赖倒转原则（Dependence Inversion Principle）
	这个是开闭原则的基础，具体内容：真对接口编程，依赖于抽象而不依赖于具体。
	4、接口隔离原则（Interface Segregation Principle）
	这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。还是一个降低类之间的耦合度的意思，从这儿我们看出，其实设计模式就是一个软件的设计思想，从大型软件架构出发，为了升级和维护方便。所以上文中多次出现：降低依赖，降低耦合。
	5、迪米特法则（最少知道原则）（Demeter Principle）
	为什么叫最少知道原则，就是说：一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。
	6、合成复用原则（Composite Reuse Principle）
	原则是尽量使用合成/聚合的方式，而不是使用继承。
	
##三、Java的23中设计模式
###1、工厂方法模式（Factory Method）
	工厂方法模式分为三种：
	1.1`com.yhcaa.factory`普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
	1.2`com.yhcab.factory`多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
	1.3`com.yhcac.factory`静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
###2、抽象工厂模式（Abstract Factory）
	工 厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，所以，从设计角度考虑，有一定的 问题，如何解决？就用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。
	'com.yhcba.factory'	
###3、单例模式（Singleton）`com.yhcca.factory`
	单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处：
	1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
	2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
	3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。（比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
###4、建造者模式（Builder）`com.yhcda.factory`
###5、原型模式（Prototype）`com.yhcea.factory`