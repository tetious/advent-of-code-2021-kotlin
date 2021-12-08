import kotlin.math.roundToInt

fun Boolean.toBit() = if (this) "1" else "0"

fun main() {
    fun part1(input: List<String>): Int {
        val counts = IntArray(input[0].length)
        input.forEach { it.forEachIndexed { i, bit -> counts[i] += bit.digitToInt() } }
        val mostCommon = counts.map { it > input.size / 2 }
        val gamma = mostCommon.joinToString("") { (it).toBit() }.toInt(2)
        val epsilon = mostCommon.joinToString("") { (!it).toBit() }.toInt(2)
        println("g: $gamma, e: $epsilon")
        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        var oxygenRating = input.toList()
        var co2Rating = input.toList()
        var index = 0
        while (oxygenRating.size != 1) {
            val mostCommon = oxygenRating.sumOf { it[index].digitToInt() } >= (oxygenRating.size / 2.0).roundToInt()
            oxygenRating = oxygenRating.filter { (it[index] == '1') == mostCommon }
            index++
        }
        index = 0
        while (co2Rating.size != 1) {
            val mostCommon = co2Rating.sumOf { it[index].digitToInt() } >= (co2Rating.size / 2.0).roundToInt()
            co2Rating = co2Rating.filter { (it[index] == '1') != mostCommon }
            index++
        }

        println("o: $oxygenRating, c: $co2Rating")
        return oxygenRating.single().toInt(2) * co2Rating.single().toInt(2)
    }

    val testInput = readInput("day_03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("day_03")
    check(part1(input) == 2035764)
    check(part2(input) == 2817661)
}
