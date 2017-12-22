fun main(args: Array<String>) {
    val a = listOf<Int>()
    a.open(1, 2)
}

//扩展List一个open方法
fun <T> List<T>.open(a: Int, b: Int) {
    print(a + b)
}