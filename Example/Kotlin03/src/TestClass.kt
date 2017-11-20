fun main(args: Array<String>) {

    //val oneMillion = 1_000_000
    //val creditCardNumber = 1234_5678_9012_3456L
    //val socialSecurityNumber = 999_99_9999L
    //val hexBytes = 0xFF_EC_DE_5E
    //val bytes = 0b11010010_01101001_10010100_10010010

    //print("$oneMillion \n")
    //print("$creditCardNumber \n")
    //print("$socialSecurityNumber \n")
    //print("$hexBytes \n")
    //print("$bytes \n")

    //val a: Int = 10000
    // true
    //print(a === a)
    //val boxedA: Int? = a
    //val anotherBoxedA: Int? = a
    // false
    //print(boxedA === anotherBoxedA)

    // 假想的代码，实际上并不能编译：
    //val a: Int? = 1 // ⼀个装箱的 Int (java.lang.Integer)
    //val b: Long? = a // 隐式转换产⽣⼀个装箱的 Long (java.lang.Long)
    //print(a == b) // 惊！这将输出“false”鉴于 Long 的 equals() 检测其他部分也是 Long

    //val b: Byte = 1
    //val i: Int = b.toInt()
    //print(i)

    //val l = 1L + 3

    //val a: Int = 3
    //<< 1
    //print("${a shl 1} \n")
    //>> 1
    //print("${a shr 1} \n")
    //>>> 1
    //print("${a ushr 1} \n")
    //and 1
    //print("and: ${a.and(5)} \n")
    //or  7
    //print("or : ${a.or(5)} \n")
    //xor 6
    //print("xor : ${a.xor(5)} \n")
    //inv -4
    //print("inv : ${a.inv()} \n")

    //var a : Char = '1'
    //print(decimalDigitValue(a))


    //定义items["1","2","3"]
    //val items = listOf<String>("1","2","3")
    //指定大小，内容为空
    //val itemNulls = arrayOfNulls<Int>(10)
    // 创建⼀个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
    //val asc = Array(5, { i -> (i * i).toString() })
    // 定义五个数 一直递增
    //val asc = Array(5, {i -> (i * i)})

    //for (a in asc) { print(a)}

    for (c in "Hello") {
        //println("$c")
    }

    val text = """
        for (c in "foo")
            print(c)
        """
    print(text)
}

/**
 * 转int
 */
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    // 显式转换为数字
    return c.toInt() - '0'.toInt()
}

