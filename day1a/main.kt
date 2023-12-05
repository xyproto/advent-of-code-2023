package main

fun main() {
    var sum: Int = 0
    var number: String
    var s = readLine()
    while (s != null) {
        number = ""
        for (r in s) {
            when (r) {
                in '0'..'9' -> number += r
                // else -> number += r
            }
        }
        val l = number.length
        if (l > 2) {
            number = number[0].toString() + number[l-1].toString()
        } else if (l == 1) {
            number += number
        }
        sum += number.toInt()
        println("$s: $number ($sum)")
        s = readLine()
    }
    println("sum: $sum")
}
