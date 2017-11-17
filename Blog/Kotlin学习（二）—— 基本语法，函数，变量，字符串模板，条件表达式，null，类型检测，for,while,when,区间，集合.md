# Kotlin学习（二）—— 基本语法，函数，变量，字符串模板，条件表达式，null，类型检测，for,while,when,区间，集合

## 一.基本语法

Kotlin的很多概念跟JAVA是有类似的，所以我应该不会像我的JAVA之旅一样那么的详细，但是不用担心，你会看的很明白的，我也是根据官方的文档来学习的

我们在IDEA中创建一个项目Kotlin02

### 1.函数(fun)

我们默认有一个主函数，就是main了

```
fun main(args: Array<String>) {
    print("主函数")
}
```

和JAVA一样，他就是程序的主入口了，当然，我们还有普通的函数

```
fun sum(): Unit {
    print("无参 无返回")
}

fun sum() {
    print("一般Unit可以省略")
}

fun sum(a: Int) {
    print("有参 无返回")
}

fun sum(): Int {
    print("无参 有返回")
    return 0;
}

fun sum(a: Int): Int {
    print("有参 有返回")
    return 0;
}
```

这里就可以对Kotlin的函数有一个比较清晰的认识了，首先，我们的无参 无返回中有一个Unit，这个就是标志
这个函数没有返回值，和JAVA中的void是一样的，而且我们一般是可以省略掉的，并且这里要注意下的就是他的函数传值
是先定义变量，再用冒号去指向类型，如a:Int b:String,并且返回值也是用冒号去指向的，如:Int

并且我们还可以将表达式作为函数体、返回值类型⾃动推断的函数，如：

```

fun sum(a: Int, b: Int) = a + b;

```

### 2.变量(val&var)

变量分三种，局部变量，顶层变量和可变变量

但是就两个修饰符val 和 var

```
	//定义Int类型的变量
    val a: Int = 1
	//定义变量 自动识别类型，如果不指定类型，就必须赋值
    val b = 2
	//没有初始值，不可操作
    val c: Int
	//赋值 val修饰只能赋值一次
	c = 3
```

用val修饰符修饰之后，只能一次赋值后就编程只读变量了，在JAVA中可以理解为常量，这里怎么理解呢，可以说是JAVA中用final修饰一样，我们来举个例子

```
    //报错
    val a: Int
    print(a + 2 )
    
    //正确
    a = 3
    print(a)
```

这里的意思就是我定义一个Int类型的a，然后输出a + 2，编译器会提示错误，因为val修饰后无值，不可操作，然后我给他赋值= 3，就可以正确输出了

这里还有一点要注意的就是，我们可以 val c: Int这样定义一个变量，先不赋值，但是如果你不指定值又不定义类型，比如val a,那是错误的，编译器无法得知你需要做什么操作

我们再来看下可变变量，用法是一样的，但是注意的事，他是可变的

```
    var a: Int = 2
    print(a)

    a++;
    print("a:" + a)
```

这里就可以明白，a输入2，然后a++，输出3

还有最后一种顶层变量，顶层变量其实就是JAVA中的全局变量，这个没什么可说的

```
//顶层
val x = 2
var y = 3

fun sum() {
    y++
    print(x + y)
}

```

这个就没什么好说的了

### 3.字符串模板($)

字符串模板也是比较简单的，就是字符引用，我们来看一段例子

```
    val boy = 5
    var girl = 7
    var all = "班级共有男孩：$boy 人，女孩：$girl 人"
    print(all)
```

然后run一下，输出

![字符串模板](http://img.blog.csdn.net/20171116132628532?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

可以看出，这里我输出的时候就引用了变量boy和girl，只需要前面加上$即可，有点类似于JAVA中的转义字符

当然，还有一些更加高级的用法，比如

```
    val boy = 5
    var girl = 7
    var all = "班级共有男孩：$boy 人，女孩：$girl 人"
    //print(all)

    //将男孩替换成女孩
    print("${all.replace("男孩","女孩")},现在班级的所有女生共有：${boy + girl}" )
```

这里我们可以看到输出

![字符串模板](http://img.blog.csdn.net/20171116133609350?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

也就是说，我们可以直接操作，当然，本质上这样转义跟下面这样并没有什么区别

```
print(all.replace("男孩","女孩") + ",现在班级的所有女生共有：" + (boy + girl))
```

你觉得哪种方便呢？

### 4.条件表达式(if else)

```
//比较大小
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
```

if else 一直都是这种写法，当然，简单判断的话，我们还可以这样去写

```
fun maxOf(a: Int, b: Int) = if (a > b) a else b
```

### 5.可空值及 null 检测(?)

还记得我们在java中怎么去写函数的嘛？比如

```
private String testOf(String x){
    String y = null;
    //通过一些逻辑的操作
    if(!TextUtils.isEnty(y)){
        y = x;
    }
    return y;
}

```

这是一段JAVA代码，我们可以看到，如果我们通过逻辑操作后可以让y赋值，但是也同样的，有存在有可能返回null的情况，但是在kotlin中，我们需要特殊处理

```
fun parseInt(str: String): Int? {

    return null;
}
```

这里注意，如果返回值有可能为空的话，需要标记？问号，不然你return null会报错

### 6.类型检测及⾃动类型转换(is)

类型检测在JAVA中都是用instanceof来处理，在kotlin中，可以用is，我们看一个例子

```
    var a:Any = "123"
    if(a is String){
        print(a.length)
    }
```

在这段代码中，我说明一下，Any是所有类都有一个共同的父类，类似于Object，但是他的神通没有Object大

而在这段代码中，首先，我用is判断了String,这里可不仅是判断，而且还类型转换了，所以为true的话，就可以输出a.length了，但是在没有调用is之前，实际上是没有length这个方法的


### 7.for循环(for in)

```
    var a = listOf(1, 2, 3, 1)
    for (b in a) {
        //错误
        //print(b + "\n")
        print("$b \n")
    }
```

这段代码中，我们定义了一个list为a,然后通过in去for循环，这里我要说一下，就是字符串模板的应用场景。

比如输出的结果需要换行，那么print(b + "\n")你这样用+号是错误的，需要print("$b \n"),在Kotlin中，in负责for循环，即最大次数为list长度

当然，如果你想问，那我想知道下标是多少怎么办？

```
    var a = listOf(1, 2, 3, 1)
    for (b in a.indices) {
        print("item:" + b + "值" + a[b] + "\n")
    }
```

实际上in只是提供循环的手段而已，真正要循环的东西，还是要自己决定，所以这里，我就循环list的下标a.indices

这样我就可以拿到下标以及对应的值，也是一样的，当然，这个输出我们可以用更官方的写法来写的：

```
print("item:$b 值${a[b]}\n")
```

一样，我们可以看到打印

![这里写图片描述](http://img.blog.csdn.net/20171116150418405?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### 8.while循环(while)

```
    var a = 0;
    while (a < 10) {
        a++;
        print(a)
    }
```

while循环没什么好讲的，你按照正常的来就好了

### 9.when表达式(when)

```
    var x = 1;
    var y = 1;
    when (x) {
        1 ->
            if(x + y > 5){
                print("a")
            }else{
                print("b")
            }
        2 -> print("x == 2")
        else -> { // 注意这个块
            print("x is neither 1 nor 2")
        }
    }
	
```

从这段代码大家可以看出一些东西来吧，没错，实际上Kotlin中的when表达式就是JAVA中的switch语句块 -> 相当于case


### 10.区间(range)

```
    val x = 5
    if (x in 1..10) {
        println("fits in range")
    }
```

我们通过int可以判断x是否在1-10的区间，当然，区间的用法还是比较多的，比如数列迭代等，这些我们后面会详细讲到

### 11.集合

集合在我们上面for循环的时候就已经出现过

```
    var a = listOf(1, 2, 3, 1)
    for (b in a) {
        print("$b \n")
    }

```

集合的用处很广泛，我们在后面还会细讲，这里举一个例子：

```
    /**
     * 有一堆水果和一堆投票员
     * 每个投票员手中有1-3张票不等
     * 且他们每个人只喜欢一种水果
     * 如果投票员吃到的这个水果就会给你投票
     * 如果总分超过5分
     * 那你就顺便合格
     * 我们假设5个投票员，3个水果
     * 请问他是否合格？
     */

    //放出3个水果
    var fruit = listOf("香蕉", "苹果", "西瓜")
    //分数
    var fractions = 0;
    for (fr in fruit) {
        if (fr is String) {
            when (fr) {
                "龙眼" -> {
                    print("+1 \n")
                    fractions = fractions + 1;
                }
                "香蕉" -> {
                    print("+2 \n")
                    fractions = fractions + 2;
                }
                "橘子" -> {
                    print("+2 \n")
                    fractions = fractions + 2;
                }
                "苹果" -> {
                    print("+2 \n")
                    fractions = fractions + 2;
                }
                "西瓜" -> {
                    print("+1 \n")
                    fractions = fractions + 1;
                }
            }
        }
    }
    //计算是否合格
    if (fractions > 5) {
        print("合格")
    } else {
        print("不合格")
    }
```

我们先看下输出结果

![这里写图片描述](http://img.blog.csdn.net/20171116173942709?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这个题出的有点粗糙，大家看的懂就行，意思就是我们只有三种水果给到三个喜欢吃的投票员，他会给我相应的分数，最后超过5分就合格，然后我们来分析下这个题目

首先我们定义了一个集合fruit来表示我当前的水果，然后我定义fractions来进行分数的累加，开始循环并且判断谁喜欢吃，给几分，最后判断是否大于5,

题目很简单，但是我们的逻辑也是从这里开始萌发的


这些大概就是Kotlin的大致介绍了，实际上这门美丽的语言不止是这些内容，当你已经了解了这些之后，我们就可以进行下一个环节，正在的开始没一个知识点的细讲了

#### 如果有兴趣的话，可以加入我的Kotlin学习小组

![这里写图片描述](http://img.blog.csdn.net/20171117134155479?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#### **我的公众号，期待你的关注**

![weixin](http://img.blog.csdn.net/20160108203741937)


























