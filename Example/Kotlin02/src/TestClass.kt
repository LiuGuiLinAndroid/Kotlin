import java.awt.Rectangle

fun main(args: Array<String>) {
    //print("主函数")

    //val a: Int = 1
    //val b = 2


    //报错
    //val a: Int
    //print(a + 2)

    //正确
    //a = 3
    //print(a)

    //var a: Int = 2
    //print(a)

    //a++;
    //print("a:" + a)

    //val boy = 5
    //var girl = 7
    //var all = "班级共有男孩：$boy 人，女孩：$girl 人"
    //print(all)

    //将男孩替换成女孩
    //print("${all.replace("男孩","女孩")},现在班级的所有女生共有：${boy + girl}" )

    //print(all.replace("男孩","女孩") + ",现在班级的所有女生共有：" + (boy + girl))


    //print(maxOf(5, 6))

    //var a:Any = "123"
    //if(a is String){
    //    print(a.length)
    //}

    //var a = listOf(1, 2, 3, 1)
    //for (b in a.indices) {
    //print("item:" + b + "值" + a[b] + "\n")
    //print("item:$b 值${a[b]}\n")
    //}

    //var a = 0;
    // while (a < 10) {
    //   a++;
    //   print(a)
    //}


    //    var x = 1;
    //    var y = 1;
    //    when (x) {
    //        1 ->
    //            if(x + y > 5){
    //                print("a")
    //            }else{
    //                print("b")
    //            }
    //        2 -> print("x == 2")
    //        else -> { // 注意这个块
    //            print("x is neither 1 nor 2")
    //        }
    //    }

    //    val x = 5
    //    if (x in 1..10) {
    //        println("fits in range")
    //    }

//    for (x in 1..10 step 2) {
//        print(x)
//    }
//    for (x in 9 downTo 0 step 3) {
//        print(x)
//    }


    /**
     * 有一堆水果和一堆投票员
     * 每个投票员手中有1-3张票不等
     * 且他们每个人只喜欢一种水果
     * 如果投票员吃到的这个水果就会给你投票
     * 如果总分超过5分
     * 那你就顺便合格
     * 我们假设5个投票员，3个水果
     * 请问他是否合格？
     */

    //放出3个水果
    var fruit = listOf("香蕉", "苹果", "西瓜")
    //分数
    var fractions = 0;
    for (fr in fruit) {
        if (fr is String) {
            when (fr) {
                "龙眼" -> {
                    print("+1 \n")
                    fractions = fractions + 1;
                }
                "香蕉" -> {
                    print("+2 \n")
                    fractions = fractions + 2;
                }
                "橘子" -> {
                    print("+2 \n")
                    fractions = fractions + 2;
                }
                "苹果" -> {
                    print("+2 \n")
                    fractions = fractions + 2;
                }
                "西瓜" -> {
                    print("+1 \n")
                    fractions = fractions + 1;
                }
            }
        }
    }
    //计算是否合格
    if (fractions > 5) {
        print("合格")
    } else {
        print("不合格")
    }
}


//fun parseInt(str: String): Int? {
//    return null;
//}

//比较大小
//fun maxOf(a: Int, b: Int): Int {
//    if (a > b) {
//        return a
//    } else {
//        return b
//    }
//}

//fun maxOf(a: Int, b: Int) = if (a > b) a else b

/*
fun sum(): Unit {
    print("无参 无返回")
}

fun sum() {
    print("一般Unit可以省略")
}

fun sum(a: Int) {
    print("有参 无返回")
}

fun sum(): Int {
    print("无参 有返回")
    return 0;
}

fun sum(a: Int): Int {
    print("有参 有返回")
    return 0;
}
*/

//顶层
//val x = 2
//var y = 3

//fun sum() {
//    y++
//    print(x + y)
//}


