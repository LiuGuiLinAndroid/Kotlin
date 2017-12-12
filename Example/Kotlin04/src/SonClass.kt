class SonClass() : BaseClass() {

}

open class Base {

    open var a = 9;

    open fun v() {
        print("Base...")
    }

    fun nv() {}
}

open class Son() : Base() {

    override var a = 8;

    override fun v() {
        super.v()
        print("Son...")
    }
}

fun main(args: Array<String>) {
    val son = Son();
    son.v()
    print(son.a)
}


open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}
interface B {
    fun f() { print("B") } // 接⼝成员默认就是“open”的
    fun b() { print("b") }
}
class C() : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调⽤ A.f()
        super<B>.f() // 调⽤ B.f()
    }
}
