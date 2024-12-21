package one

import util.readInput
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
    val rightMap = mutableMapOf<Int, Int>()
    right.forEach { value ->
        val count = rightMap[value] ?: 0
        rightMap[value] = count + 1
    }
    var similarityScore = 0
    left.forEach { value ->
        val appearances = rightMap[value] ?: 0
        val score = value * appearances
        similarityScore += score
    }
    println("SIMILARITY SCORE: $similarityScore")
}
