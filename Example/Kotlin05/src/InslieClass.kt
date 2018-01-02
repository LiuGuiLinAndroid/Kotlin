import java.awt.SystemColor.window
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun main(args: Array<String>) {
    val h = H.ONE.signal()
    print(h)

    val window: Window? = null
    if (window != null) {
        window.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {

            }

            override fun mouseEntered(e: MouseEvent?) {

            }
        })
    }
}


enum class H() {
    ONE {
        override fun signal() = TWO
    },
    TWO {
        override fun signal() = ONE
    };
    abstract fun signal(): H
}

enum class K(val number: Int) {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5)
}

fun H(ins: Outer.Inner) {
    print("Hello")
}

class TestClass {
    private val a: Int = 5

    class OutTest {
        fun b() = 1;
    }
}

class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

// == 1
val demo = Outer().Inner().foo()







