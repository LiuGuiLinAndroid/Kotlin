fun main(args: Array<String>) {

    val user = User("张三", 18)
    val newUser = user.copy(age = 19)
    print(newUser.toString())
}

//数据
data class User(val name: String, val age: Int)

class Box<T>(t: T) {
    var value = t
}

abstract class Source<out T> {
    abstract fun next(): T
}

fun Test(str: Source<String>) {
    var objects: Source<Any> = str
}

abstract class Comparable<in T> {
    abstract fun compareTo(other: T): Int
}
fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 拥有类型 Double，它是 Number 的⼦类型
    // 因此，我们可以将 x 赋给类型为 Comparable <Double> 的变量
    val y: Comparable<Double> = x // OK！
}

