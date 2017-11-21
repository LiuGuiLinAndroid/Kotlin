## 一.基本类型

Kotlin的数字表现，如下

- Double  64
- Float   32
- Long    64
- Int     32
- Short   16
- Byte    8

这些就是全部的定义数字的方式了，而我们一般的写法也和JAVA类似

- 十进制：  10086
- 十六进制：0x0F
- 二进制：  0b00001011
- Long类型：10086L
- Float类型:10086f
- Double类型:100.86

同时，Kotlin上有一个下划线的定义，可以让代码的可读性更加的强，我们来看下

```
fun main(args: Array<String>) {
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    print("$oneMillion \n")
    print("$creditCardNumber \n")
    print("$socialSecurityNumber \n")
    print("$hexBytes \n")
    print("$bytes \n")
}
```

这段代码输出的数字

![这里写图片描述](http://img.blog.csdn.net/20171120110022879?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

下划线并不像JAVA一样会影响我们的代码，而是让我们的代码可读性变得更强

并且在JAVA平台中，== 和 === 的概念 就跟我们JAVA中 == 和eques类似

```
    val a: Int = 10000
    // true
    print(a === a)
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    // false
    print(boxedA === anotherBoxedA)
```

这段代码中，我们可以看到，我们定义了一个Inta,又定义了两个可空Int 赋值 a，结果算出===false，但是如果我们
改成== ，那就是值相等了，===是地址相同，很明显，我们是两个不同的变量，所以false

另外，在Kotlin中，小类型也不是大类型的子类，所以不存在强转的概念

比如这种错误的示范

```
	val b: Byte = 1 
	val i: Int = b 

```

这就隐式转换，但是我们可以用个显示转换来达到我们的需求

```
    val b: Byte = 1
    val i: Int = b.toInt()
    print(i)
```

每个数字都是可以通过显示转换来达到自己想要的转换

我们再来看下逻辑运算

- shl(bits) ‒ 有符号左移 (Java 的 << )
- shr(bits) ‒ 有符号右移 (Java 的 >> )
- ushr(bits) ‒ 有符号右移 (Java 的 >>> )
- and(bits) ‒ 位与
- or(bits) ‒ 位或
- xor(bits) ‒ 位异或
- inv() ‒ 位非

我们来写一段演示的示例

```

    val a: Int = 3
    //<< 1
    print("${a shl 1} \n")
    //>> 1
    print("${a shr 1} \n")
    //>>> 1
    print("${a ushr 1} \n")
    //and 1
    print("and: ${a.and(5)} \n")
    //or  7
    print("or : ${a.or(5)} \n")
    //xor 6 
    print("xor : ${a.xor(5)} \n")
    //inv -4 
    print("inv : ${a.inv()} \n")

```

再来看下Char,Char不能作为一个单独的字符或数字存在，需要‘’单引号声明，比如

```
    var a : Char = '1'
```

我们再来看下如何定义一个数组

```
    //定义items["1","2","3"]
    val items = listOf<String>("1","2","3")
    //指定大小，内容为空
    val itemNulls = arrayOfNulls<Int>(10)
    // 创建⼀个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
    //val asc = Array(5, { i -> (i * i).toString() })
    // 定义五个数 一直递增
    val asc = Array(5, {i -> (i * i)})
```

listOf直接声明，arrayOfNulls声明一个长度固定的空数组Array定义一个指定长度，值的数组

再来看下字符串

```
    for (c in "Hello") {
        println("$c")
    }
```
	
这是我们常见的字符串，可以包含转义，还有一种

```
    val text = """
        for (c in "foo")
            print(c)
        """
```
		
这是原生的字符串，用三个"""表示，里面不包含转义，是什么就是什么，当然，这样的话里面就有很多空格了

```
    val text = """
        |for (c in "foo")
            |print(c)
        """.trimMargin()
    print(text)
```
我们可以|声明当前起始位，并且trimMargin()去除空格，得到的结果

![这里写图片描述](http://img.blog.csdn.net/20171120144734175?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

如果你没有这样处理的话，你输出的值是这个样子的

![这里写图片描述](http://img.blog.csdn.net/20171120144820829?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 二.包

包的作用我相信大家都是知道的

```

package com.liuguilin.kt_package

fun main(args: Array<String>) {

    print(sum(1,3))
}

fun sum(a: Int, b: Int): Int {
    return a + b;
}

```

## 三.控制流：if、when、for、while

### 1.if表达式

在kotlin中，if的用法不局限于判断，他还会有返回，所以我们的写法也很多，比如

```
    val a = 12;

    //传统
    if (a > 10) {
        print(">")
    } else {
        print("<")
    }

    //表达式
    if (a > 10) print(">") else print("<")

    //表达式
    var b = if (a > 10) 10 else 20
```

### 2.When表达式

```
    val today = 4;
    when (today) {
        1 -> print("春季")
        2 -> print("春季")
        3 -> print("春季")
        4 -> print("夏季")
        5 -> print("夏季")
        6 -> print("夏季")
        7 -> print("秋季")
        8 -> print("秋季")
        9 -> print("秋季")
        10 -> print("冬季")
        11 -> print("冬季")
        12 -> print("冬季")
    }

```

但是我们一般是需要else结尾的，而且我们可以用in来表达

```
    val today = 4;
    when (today) {
        in 1..3 -> print("春季")
        in 4..6 -> print("夏季")
        in 7..9 -> print("秋季")
        in 10..12 -> print("冬季")
        else -> print("error")
    }
```

当然，你还可以用is来判断类型，这里就不讲了

### 3.For 循环

```
    var items = listOf(1,2,3);

    //out 123
    for(a in items) print(a)

    //out 012
    for (a in items.indices) print(a)

    //out 0 , 1  1 , 2  2 , 3
    for ((a,b)in items.withIndex()) print("$a , $b \n")
```

### 4.While 循环

```
    var a = 5;

    while (a > 3){
        print(a)
        a--;
    }

    do {
        print(a)
        a--;
    }while (a > 3)
```

## 四.Break和continue

Kotlin 有三种结构化跳转表达式：

- return。默认从最直接包围它的函数或者匿名函数返回。
- break。终止最直接包围它的循环。
- continue。继续下一次最直接包围它的循环。

我们来看一个例子

```
    var items = listOf(1, 3, 5, 7, 9)

    for (a in items) {
        if (a == 5) {
            continue | break | return
        }
        print("$a \n")
    }
```

这里循环一个数组，如果等于5就分别执行continue，break，return，如果是break，return会跳出循环，也就
只会打印1,3而continue会跳出本次循环，也就会打印1,3,7,9

#### 如果有兴趣的话，可以加入我的Kotlin学习小组

![这里写图片描述](http://img.blog.csdn.net/20171117134155479?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#### **我的公众号，期待你的关注**

![weixin](http://img.blog.csdn.net/20160108203741937)




















