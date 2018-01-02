# 数据类，泛型，嵌套类与内部类，对象表达式和对象声明

## 一.数据类

数据类和JAVA中的javabean类似，只作用于保存一些数据，所以如果创建，会某人生成一些函数，并且会被标记为data:

- equals() / hashCode() 

- toString()

- componentN()

- copy()

我们来看下标准的写法

```
data class User(val name: String, val age: Int)
```

为了保证这个类的意义，所以一般都会有一些约束，比如

- 主构造函数需要⾄少有⼀个参数

- 主构造函数的所有参数需要标记为 val 或 var

- 数据类不能是抽象、开放、密封或者内部的

### 1.复制

复制是每个数据类中默认的函数，在很多情况下，我们需要复制⼀个对象改变它的⼀些属性，但其余部分保持不变，有点类似修改某个数据，看下实际代码

```
fun main(args: Array<String>) {

    val user = User("张三",18)
    val newUser = user.copy(age = 19)
    print(newUser.toString())
}
//数据
data class User(val name: String, val age: Int)
```

可以看到，这里的User数据类，我们声明之后，调用copy函数，改变年龄为19，然后输出

![这里写图片描述](http://img.blog.csdn.net/20171222162623627?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 二.泛型

泛型很常见，相信大家都熟悉

```
class Box<T>(t: T) {

	var value = t

}
```

### 1.型变

JAVA中有通配符这一说法，但是处理起来会比较麻烦，但是在kt中，就没有这样的概念，我们来看下代码：

![这里写图片描述](http://img.blog.csdn.net/20171227110055472?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在图中，我们可以看到编译器会提示不同类型，也就是Object != String

JAVA会禁止这样的事情来保证运行时的安全，但是这里就会有一些影响，比如Collection中的addAll

```
public interface Collection<E> extends Iterable<E> {
	boolean addAll(Collection<? extends E> c);
}

```

为什么明明这里定义的是E，但是类型还是？ extends E,然道不是：

```
public interface Collection<E> extends Iterable<E> {
	boolean addAll(Collection<E> c);
}
```

这也就是JAVA中的一个通配准则：列表优先数组

### 2.声明处型变

我们现在假设一个泛型

```
//JAVA
interface Source<T> {
    T nextT();
}
```

这个接口不存在任何以T为参数的方法，那么，在 Source <Object> 类型的变量中存储 Source <String> 实例的引⽤是极为安全的⸺没有消费者-⽅法可以调⽤。但是 Java 并不知道这
⼀点，并且仍然禁⽌这样操作，为了修正这一点，我们必须声明对象的类型为 Source<? extends Object> ，这是毫⽆意义的，所以在kt中，有一种方法向编译器解释这种情况，叫做声明处
型变，也就是out修饰符

```
abstract class Source<out T> {
    abstract fun next(): T
}

fun Test(str: Source<String>) {
    var objects: Source<Any> = str
}
```

一般原则是：当一个类 C 的类型参数 T 被声明为 out 时，它就只能出现在 C 的成员的输出-位置，但回报是 C<Base> 可以安全地作为
C<Derived> 的超类。

简而言之，他们说类 C 是在参数 T 上是协变的，或者说 T 是一个协变的类型参数。你可以认为 C 是 T 的⽣产者，⽽不是 T 的消费者。
out修饰符称为型变注解，并且由于它在类型参数声明处提供，所以我们讲声明处型变。这与 Java 的使用处型变相反，其类型用途通配符使得类型协变。
另外除了 out，Kotlin 还补充了一个型变注释：in。它使得一个类型参数逆变：只可以被消费而不可以被生产

```
abstract class Comparable<in T> {
    abstract fun compareTo(other: T): Int
}
fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 拥有类型 Double，它是 Number 的⼦类型
    // 因此，我们可以将 x 赋给类型为 Comparable <Double> 的变量
    val y: Comparable<Double> = x // OK！
}
```

> PS:泛型这块后续用一篇专门来讲

## 三.嵌套类与内部类

类是可以嵌套在其他类的，这个大家都知道对吧

```
fun main(args: Array<String>) {
    val test = TestClass.OutTest().b()
    print(test)
}

class TestClass {
    private val a: Int = 5

    class OutTest {
        fun b() = 1;
    }
}

```

### 1.内部类

类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引⽤

```
class Outer {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}
// == 1
val demo = Outer().Inner().foo()
```

### 2.匿名内部类

匿名内部类和大家想的一样，需要使用对象表达式，下面讲了对象表达式再讲匿名内部类

### 3.枚举类

枚举类就是想实现类型安全来枚举，实际上和我们的正常用法是一样的

```
enum class K{
    ONE,TWO,THREE,FOUR,FIVE
}

val k = K.ONE
```

#### a.初始化

没一个枚举都是枚举类的实例，所以我们可以这样初始化

```
fun main(args: Array<String>) {
    val k = K.FOUR
    print(k.number)
}

enum class K(val number:Int){
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5)
}
```

#### b.匿名类

枚举也可以声明自己的匿名内部类哦

```
fun main(args: Array<String>) {
    val h = H.ONE.signal()
    print(h)
}

enum class H() {
    ONE {
        override fun signal() = TWO
    },
    TWO {
        override fun signal() = ONE
    };
    abstract fun signal(): H
}
```

如果想定义其他成员，需要用;分开，和JAVA一样

## 四.对象表达式和对象声明

有时候，我们需要创建一个对某个类做了轻微改动的类的对象，而不用为之显式声明新的子类。Java 用匿名内部类 处理这种情况。Kotlin 用对象表达
式和对象声明对这个概念

这也就是上面在讲匿名内部类的时候说的，在这里体现

我们拿这个例子来说明：

```
        //JAVA
        window.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }
        });
```

这是给window添加测量监听，所要实现的匿名内部类，如果是kt该如何写？

```
	//Kotlin
    val window: Window? = null
    if (window != null) {
        window.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {

            }

            override fun mouseEntered(e: MouseEvent?) {

            }
        })
    }
```










