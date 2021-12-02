fun main() {
    fun countIncreases(input: List<Int>): Int {
        return input.mapIndexed { i, it -> if (i > 0 && it > input[i - 1]) 1 else 0 }.sum()
    }

    fun part1(input: List<String>): Int {
        return countIncreases(input.map { it.toInt() })
    }

    fun part2(input: List<String>): Int {
        val windowed = List(input.size - 2) { i -> input.slice(i..i + 2).sumOf { it.toInt() } }
        return countIncreases(windowed)
    }

    val testInput = readInput("day_01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("day_01")
    println(part1(input))
    println(part2(input))
}
