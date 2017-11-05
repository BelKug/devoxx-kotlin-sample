package be.kugbel.sample.devoxx

inline fun operation(parameter: String, op: (position: Int, number: Int) -> Unit) {
    println("First Line")
    op(2, 3)
    println("Second Line")
}

fun main(args: Array<String>) {

    operation(""){ parameter1, parameter2 ->
        println("From the lambda" + parameter1 + parameter2)
    }

}