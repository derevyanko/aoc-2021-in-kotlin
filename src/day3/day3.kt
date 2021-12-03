import kotlin.math.pow

fun main() {
    partTwo()
}

private fun partOne() {
    val input = readInput("day3/input")
    val input_size = input.size

    val gammaBinary: MutableList<Int> = mutableListOf<Int>()
    input[0].indices.forEach({ index ->
        gammaBinary.add(getPositionGreater(input, index, input_size))
    })

    var gammaDecimal = 0.0
    var eps = 0.0
    gammaBinary.reversed().forEachIndexed({ index, elem ->
        gammaDecimal += 2.toDouble().pow(index) * elem
        eps += 2.toDouble().pow(index) * ((elem + 1) % 2)
    })

    val answer = gammaDecimal * eps
    println(answer)
}

private fun getPositionGreater(input: List<String>, position: Int, input_size: Int): Int {
    return if (input.filter { it[position] == '1' }.size >= input_size / 2.0) 1 else 0
}

private fun partTwo() {
    val input = readInput("day3/input")

    var oxygenGenerator = ""
    var input2 = input
    input[0].indices.forEach({ index ->
        if (input2.size == 2) {
            if (input2[0][index] == '1') { oxygenGenerator = input2[0] }
            else { oxygenGenerator = input2[1] }
            return@forEach
        }
        val more = getPositionGreater(input2, index, input2.size)
        input2 = input2.filter { it[index].toString() == more.toString() }
    })
    println(oxygenGenerator)

    var CO2 = ""
    input2 = input
    input[0].indices.forEach({ index ->
        if (input2.size == 2) {
            if (input2[0][index] == '0') { CO2 = input2[0] }
            else { CO2 = input2[1] }
            return@forEach
        }
        if (input2.size == 1) {
            CO2 = input2[0]
            return@forEach
        }
        val more = (getPositionGreater(input2, index, input2.size) + 1) % 2
        input2 = input2.filter { it[index].toString() == more.toString() }
        println("$more $index $input2")
    })
    println(CO2)

    var oxygenGeneratorDecimal = 0.0
    oxygenGenerator.reversed().forEachIndexed({ index, elem ->
        oxygenGeneratorDecimal += 2.toDouble().pow(index) * elem.toString().toInt()
    })

    var CO2Decimal = 0.0
    CO2.reversed().forEachIndexed({ index, elem ->
        CO2Decimal += 2.toDouble().pow(index) * elem.toString().toInt()
    })

    println(oxygenGeneratorDecimal * CO2Decimal)
}
