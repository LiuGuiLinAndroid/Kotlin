# 数据类，泛型

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












