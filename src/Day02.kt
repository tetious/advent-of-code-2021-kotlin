fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0

        for (action in input) {
            val (direction, distance) = action.split(" ")
            when (direction) {
                "up" -> depth -= distance.toInt()
                "down" -> depth += distance.toInt()
                "forward" -> horizontal += distance.toInt()
                else -> throw Exception("Unknown direction $direction!")
            }
        }

        println("part1: $horizontal, $depth")
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0

        for (action in input) {
            var aim = 0
            val (direction, distanceStr) = action.split(" ")
            val distance = distanceStr.toInt()
            when (direction) {
                "up" -> aim -= distance
                "down" -> aim += distance
                "forward" -> {
                    horizontal += distance
                    depth += aim * distance
                }
                else -> throw Exception("Unknown direction $direction!")
            }
        }

        println("part2: $horizontal, $depth")
        return horizontal * depth
    }

    val testInput = readInput("day_02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("day_02")
    check(part1(input) == 2039256)
    check(part2(input) == 1856459736)
}
