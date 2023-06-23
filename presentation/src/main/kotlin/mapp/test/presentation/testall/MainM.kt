package mapp.test.presentation.testall

fun main() {

    val a = "Carabus (Goniocarabus) sogdianus Semenov, 1898.\n" +
            "Carabus\n" +
            "Carabidae\n" +
            "Coleoptera "

    println("avval:")
    println(a)
    println("----------------------------")

    val b = a.reverseStr()

    println("Keyin:")
    println(b)
    println("----------------------------")

}

class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

val demo = Outer().Inner().foo() // == 1

data class TestDataClass(val age: Int) {
    val name: String = ""

}

class SimpleCLassTest {
    private var name: String? = null

    constructor()
    constructor(name: String) {
        this.name = name
    }
}


fun String.reverseStr(): String {
    val splStr = this.split("\n")
    var str = ""
    splStr.forEachIndexed { index, value ->
        val appendIt = when (index) {
            0 -> "T: $value"
            1 -> "A: $value"
            2 -> "O: $value"
            3 -> "T: $value"
            else -> ""
        }
        str = "$appendIt\n$str"
    }

    return str

}


class TestNullable() {

}
