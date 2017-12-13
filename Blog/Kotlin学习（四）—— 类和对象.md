# 类和对象，继承，覆盖，抽象类，属性和字段，接口，可见性修饰符，扩展

## 一.类和对象

### 1. 类

Kotlin和java的类的声明都是一样的，用class表示,比如

```
class TestClass {
    
}
```

如果是空类的话，大括号都可以省了

### 2.构造函数

一个主构造函数和多个次要函数，主函数在类名后，如

```
class TestClass {
    //主函数
    class TestClass constructor(firstName: String) {
        init {
            print("这里初始化")
        }
    }
}
```
如果主构造函数没有任何注解或者可⻅性修饰符，可以省略这个 constructor 关键字。
并且主构造函数不允许任何代码，初始化的代码可以放在init块中

我们再来看下次构造函数

类也可以声明前缀有 constructor的次构造函数：

```
class Person {
		constructor(parent: Person) {
		parent.children.add(this)
	}
}
```

### 3.实例化类对象

Kotlin中没有new，所以直接调用

```
class TestClass {
    //主函数
    class TestClass constructor(firstName: String) {
        init {
            print("这里初始化")
        }
    }
    constructor(firstName: String) {
        print("次构造函数")
    }
}

class Test{

    //实例化类对象
    val test = TestClass("lgl");
}

```

## 二.继承

所有的类都有一个超类Any，有点类似于JAVA中的Object，但是他们确是不同的，只是概念相似而已，因为Any只有有数的几个方法

这里我们定义一个基类BaseClass

```
 open class BaseClass {
     class BaseClass constructor(str:String){

     }
 }
```

>这里的open，是公开的意思，和JAVA中的final完全相反

那我们再定义一个类去继承基类

```
class SonClass : BaseClass(){

}

```

当然，括号都是可以取消的

如果类没有主构造函数，那么每个次构造函数必须使⽤ super 关键字初始化其基类型，比如我们Android中的使用

```
class MyView : View {
	constructor(ctx: Context) : super(ctx)
	constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}

```

## 三.覆盖

这个很好理解，有继承就可以覆盖，我们来看一段代码

```
open class Base {
    open fun v() {
        print("Base...")
    }
    fun nv() {}
}

class Son() : Base() {
    override fun v() {
        print("Son...")
    }
}

fun main(args: Array<String>) {
    val son = Son();
    son.v()
}
```

这里有一个被open修饰的Base,里面有个Base方法，里面有打印，我现在有一个Son类，继承Base,并且override修饰重写v方法，再打印，那我的main方法，实例化这个对象后调用，打印的就是Son...了

![这里写图片描述](http://img.blog.csdn.net/20171212164326102?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

标记为 override 的成员本⾝是开放的，也就是说，它可以在子类中覆盖，如果不想再次被覆盖，可以再修饰一个final

上面提到的是方法的覆盖，我们还可以覆盖属性，但是也是同样的，需要override修饰，比如

```

open class Base {

    open var a = 9;

    open fun v() {
        print("Base...")
    }

    fun nv() {}
}

class Son() : Base() {

    override var a = 8;

    override fun v() {
        print("Son...")
    }
}

fun main(args: Array<String>) {
    val son = Son();
    son.v()
    print(son.a)
}

```

在这段代码中，我们可以看到在基类中定义了一个属性a,然后子类中覆盖了一个a，输出的就是子类的a值了

如果我们想用到父类的方法，可以使用super

```
class Son() : Base() {

    override var a = 8;

    override fun v() {
        super.v()
        print("Son...")
    }
}

```

如果你是砸死内部类中想使用，那么需要super@Son.v()

在 Kotlin 中，实现继承由下述规则规定：如果⼀个类从它的直接超类继承相同成员的多个实现，它必须覆盖这个成员并提供其⾃⼰的实现（也许⽤继承来
的其中之⼀）。为了表⽰采⽤从哪个超类型继承的实现，我们使⽤由尖括号中超类型名限定的 super，如 super<Base> ：

```
open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}
interface B {
    fun f() { print("B") } // 接⼝成员默认就是“open”的
    fun b() { print("b") }
}
class C() : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调⽤ A.f()
        super<B>.f() // 调⽤ B.f()
    }
}

```

## 四.抽象类

```
abstract class Impl{
    abstract open fun f()
}

class Impl1():Impl(){
    
    override fun f() {

    }
}

```

这里的open可以不声明，并且我们可以一个抽象成员覆盖一个非抽象的开放成员，如例子

```
	open class Base {
		open fun f() {}
	}
	abstract class Derived : Base() {
		override abstract fun f()
	}

```

## 五.属性和字段

我相信大家对属性应该是比较了解的，我们在第二篇的时候也已经说过

```
class H {
    var a: String = "Hello"
    var b: Int = 0
    var c: Boolean = true;
}
```

想要调用的话

```
fun main(args: Array<String>) {
    val h = H();
    print("a:${h.a}b:${h.b}c:${h.c}")
}
```

在kt中，get和set就比较有意思了，正确的语法是：

```
var <propertyName>[: <PropertyType>] [= <property_initializer>]
	[<getter>]
	[<setter>]
```

如下代码

```
class H {
    var a: String
        get() = this.toString()
        set(value) {
            a == value
        }
    var b: Int = 0
    val c: Boolean = true
}
```

我就定义了a的get和set

## 六.接口

kt的接口的关键字interface，比如

```
interface Impl {
    fun A()
    fun B() {
        //可选方法体
    }
}
```

如果你想实现一个接口，你可以

```
class Tests : Impl {

    override fun A() {

    }
    //B方法可以不需要实现
}

```

你也可以在接口中定义一些属性，但是必须是抽象的或者对外提供访问的

```
interface Impl {

    //抽象
    val a: String
    val b: String
        get() = "Hello"

    fun A()
    fun B() {
        //可选方法体
    }
}

class Tests() : Impl {

    override val a: String = "Hello"
    
    override fun A() {

    }
    //B方法可以不需要实现
}

```

## 七.可见性修饰符

kt中有四种可见性修饰符，private 、protected 、internal 和 public，默认是public

- public 随处可见

- private 声明他的文件中可见

- internal 相同模块可见

- protected 不适用于顶层声明

这里还有一点需要注意的是，在JAVA中我们private中修饰的变量最终可以通过set/get的方式去访问，但是在kt中，外部类是不能访问内部类修饰的private成员


## 八.扩展



























