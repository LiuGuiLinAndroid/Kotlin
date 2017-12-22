fun main(args: Array<String>) {

    val user = User("张三",18)
    val newUser = user.copy(age = 19)
    print(newUser.toString())
}
//数据
data class User(val name: String, val age: Int)

class Box<T>(t: T) {
    var value = t
}