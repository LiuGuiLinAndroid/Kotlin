class TestClass {
    //主函数
    class TestClass constructor(firstName: String) {
        init {
            print("这里初始化")
        }
    }
    constructor(firstName: String) {
        print("次构造函数")
    }
}

class Test{

    //实例化类对象
    val test = TestClass("lgl");
}