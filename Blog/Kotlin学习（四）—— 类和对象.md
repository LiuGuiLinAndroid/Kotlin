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

