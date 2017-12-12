abstract class Impl {
    abstract fun f()
}

class Impl1() : Impl() {

    override fun f() {

    }

}

class H {
    var a: String
        get() = this.toString()
        set(value) {
            a == value
        }
    var b: Int = 0
    val c: Boolean = true
}

fun main(args: Array<String>) {
    val h = H();
    h.a == "Hello"
    //print("a:${h.a}b:${h.b}c:${h.c}")

}