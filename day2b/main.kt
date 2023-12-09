/*
 * cubes: red | green | blue
 *
 * random pick of N cubes, that are placed back
 *
 *  record the info for each game
 *
 * semicolon between random picks
 *
 * Game1: 3 blue, 4 red; 1 red, 2 green
 *
 */

fun String.splitN(delimiter: String, limit: Int = 0): List<String> =
    split(delimiter, limit = limit)

fun String.trimSpace() =
    trim()

fun List<String>.trimSpace() =
    map { it.trimSpace() }

// splitTrim will return a list with the original string if no delimiter is found to split on
// if a delimiter is found, the string will be split into a list and each element will be trimmed on both sides
fun String.splitTrim(delimiter: String = " ", limit: Int = 0): List<String> =
    split(delimiter, limit = limit).trimSpace()

fun String.toIntOrZero(): Int = toIntOrNull() ?: 0

fun String.leftWord(delimiter: String = " "): String = splitTrim(delimiter = delimiter)[0]

fun String.rightWord(delimiter: String = " "): String = splitTrim(delimiter = delimiter)[1]

fun String.leftInt(): Int = leftWord().toIntOrZero()

fun String.rightInt(): Int = rightWord().toIntOrZero()

fun main() {
    var maxRed = 0
    var maxGreen = 0
    var maxBlue = 0
    var sum = 0

    while (true) {
        // Read a line or break out
        val line = readLine() ?: break

        if (!line.contains(":")) continue
        val (gameName, pickString) = line.splitN(":", 2).trimSpace()

        val picks = pickString.splitTrim(";")

        val gameID = gameName.rightInt()

        for (pick in picks) {
            val colorPicks = pick.splitTrim(",")
            for (colorPick in colorPicks) {
                val count = colorPick.leftInt()
                val color = colorPick.rightWord()
                //println("color $color count $count")

                // DAY 2b is about finding the max of each color for each game, because these show what has to have been in the big bag, at the minimum

                if (color == "red" && count > maxRed) {
                    maxRed = count
                }
                if (color == "green" && count > maxGreen) {
                    maxGreen = count
                }
                if (color == "blue" && count > maxBlue) {
                    maxBlue = count
                }
            }
        }
        val product = maxRed * maxGreen * maxBlue
        println("Game $gameName ($maxRed, $maxGreen, $maxBlue) product ${product}")
        sum += product
        maxRed = 0
        maxGreen = 0
        maxBlue = 0
    }
    println("Sum of all products: $sum")
}
