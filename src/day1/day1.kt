fun main() {
    partTwo()
}

private fun partOne() {
    val input = readInput("/day1/input").map { it.toInt() }

    val answer = greaterThanPreviousCount(input)

    println(answer)
}

private fun partTwo() {
    val input = readInput("/day1/input").map { it.toInt() }
    val input_size = input.size

    val sums = mutableListOf<Int>()
    for (i in 0..input_size - 3) {
        sums.add(input[i] + input[i + 1] + input[i + 2])
    }

    val answer = greaterThanPreviousCount(sums)
    println(answer)
}

private fun greaterThanPreviousCount(input: List<Int>): Int {
    val booleanList = input.indices.map { index ->
        if (index == 0) false
        else input[index - 1] < input[index]
    }
    val answer = booleanList.count { it }
    return answer
}