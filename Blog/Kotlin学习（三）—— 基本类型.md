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




























