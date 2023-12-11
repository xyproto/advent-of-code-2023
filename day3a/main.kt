fun String.splitN(delimiter: String, limit: Int = 0): List<String> =
    split(delimiter, limit = limit)

fun String.trimSpace() =
    trim()

fun List<String>.trimSpace() =
    map { it.trimSpace() }

fun String.splitTrim(delimiter: String = " ", limit: Int = 0): List<String> =
    split(delimiter, limit = limit).trimSpace()

fun String.toIntOrZero(): Int = toIntOrNull() ?: 0

fun String.leftWord(delimiter: String = " "): String = splitTrim(delimiter = delimiter)[0]

fun String.rightWord(delimiter: String = " "): String = splitTrim(delimiter = delimiter)[1]

fun String.leftInt(): Int = leftWord().toIntOrZero()

fun String.rightInt(): Int = rightWord().toIntOrZero()

// 42.each { println("$it") }
fun Int.each(action: (Int) -> Unit) {
    for (i in 1..this) {
        action(i)
    }
}

fun main() {
    var x = 0
    var y = 0

    while (true) {
        // Read a line or break out
        val line = readLine() ?: break

        println(line)

        for (r in line) {
            when (r) {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> println("digit $r at $x,$y")
                '.' -> {}
                else -> println("symbol $r at $x,$y")
            }
            x++
        }
        y++

    }
}
