fun main() {
    partTwo()
}

private fun partOne() {
    val input = readInput("day2/input").map { it.split(" ") }

    val forwardSum = input.filter { it[0] == "forward" }.sumOf { it[1].toInt() }
    val downSum = input.filter { it[0] == "down" }.sumOf { it[1].toInt() }
    val upSum = input.filter { it[0] == "up" }.sumOf { it[1].toInt() }

    val depth = downSum - upSum

    val answer = forwardSum * depth

    println(answer)
}

private fun partTwo() {
    val input = readInput("day2/input").map { it.split(" ").run { Pair(this[0], this[1].toInt()) } }

    var (aim, forward, depth) = listOf(0, 0, 0)
    input.forEach({step ->
        when (step.first) {
            "down" -> aim += step.second
            "up" -> aim -= step.second
            "forward" -> {
                forward += step.second
                depth += aim * step.second
            }
        }
    })

    println(forward * depth)
}
