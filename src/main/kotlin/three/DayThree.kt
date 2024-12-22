package three

import util.readInput

val findRegex = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()

fun main() {
    val input = readInput("/day-3/input.txt") ?: ""
    val matches = findRegex.findAll(input)
    var total = 0
    for (match in matches) {
        val vals = match.value.substring(match.value.indexOf('(') + 1, match.value.indexOf(')'))
        val factors = vals.split(',').map { v -> v.toInt() }
        val product = factors.first() * factors.last()
        total += product
    }
    println("The total is: $total")
}
