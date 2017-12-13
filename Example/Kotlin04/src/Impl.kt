

abstract class Implx {
    abstract fun f()
}

class Impl1() : Implx() {

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
        val s = SonClass();
        C();
    }
    //B方法可以不需要实现
}

