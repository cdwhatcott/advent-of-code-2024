package one

import util.readInput
import kotlin.math.abs
import kotlin.system.exitProcess

fun main() {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    val lines = readInput("/day-1/part-one-input.txt")?.lines()
    if (lines.isNullOrEmpty()) {
        println("Problem with input")
        exitProcess(1)
    }
    for (line: String in lines) {
        val tokens = line.split("\\s+".toRegex(), limit = 2)
        left.add(tokens.first().toInt())
        right.add(tokens.last().toInt())
    }
    if (left.isEmpty() || right.isEmpty() || left.size != right.size) {
        println("Problem with left/right lists")
        exitProcess(1)
    }
    left.sort()
    right.sort()
    var totalDistance = 0
    left.forEachIndexed { index, leftVal ->
        val rightVal = right[index]
        val distance = abs(leftVal - rightVal)
        println("left: $leftVal, right: $rightVal => distance $distance")
        totalDistance += distance
    }
    println("TOTAL DISTANCE: $totalDistance")
}
