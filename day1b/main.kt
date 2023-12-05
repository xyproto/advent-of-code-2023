data class Num(private var n: Int = 0) {

    // "zero" is skipped on purpose
    private val allWords = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    override fun toString(): String {
        return toWord(n) ?: ""
    }

    // the positions are unique for the found strings, so Int must be the key
    fun indexes(s: String, startIndex: Int = 0): MutableMap<Int, String> {
        var m: MutableMap<Int, String> = mutableMapOf<Int, String>()
        for (word in allWords) {
            var pos = s.indexOf(word, startIndex)
            while (pos != -1) {
                m[pos] = word
                // +1 to look from the next position instead of repeating the lookup
                pos = s.indexOf(word, pos + 1)
            }
        }
        return m
    }
}

fun toInt(s: String?): Int? {
    return when (s) {
        "zero", "0" -> 0
        "one", "1" -> 1
        "two", "2" -> 2
        "three", "3" -> 3
        "four", "4" -> 4
        "five", "5" -> 5
        "six", "6" -> 6
        "seven", "7" -> 7
        "eight", "8" -> 8
        "nine", "9" -> 9
        else -> null
    }
}

fun toWord(n: Int?): String? {
    return when (n) {
        0 -> "zero"
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        else -> null
    }
}

fun toDigit(n: Int?): String? {
    return when (n) {
        0 -> "0"
        1 -> "1"
        2 -> "2"
        3 -> "3"
        4 -> "4"
        5 -> "5"
        6 -> "6"
        7 -> "7"
        8 -> "8"
        9 -> "9"
        else -> null
    }
}

fun main() {
    var sum: Int = 0

    var line: String? = readLine()
    while (line != null) {
        println(line)
        var n = Num()
        val indexMap = n.indexes(line) // From position to found string

        val minElement = indexMap.minByOrNull { it.key }
        val minString: String = minElement?.value ?: ""

        val maxElement = indexMap.maxByOrNull { it.key }
        val maxString: String = maxElement?.value ?: ""

        val minNumberString = toDigit(toInt(minString)) ?: ""
        val maxNumberString = toDigit(toInt(maxString)) ?: ""

        val numberString = minNumberString + maxNumberString

        val number: Int? = numberString.toIntOrNull()
        sum += number ?: 0

        println("minString $minString maxString $maxString numberString $numberString number $number sum $sum")

        line = readLine()
    }
}
