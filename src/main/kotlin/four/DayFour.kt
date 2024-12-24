package four

import util.readInput

val xmasRegex = "xmas".toRegex(RegexOption.IGNORE_CASE)
val samxRegex = "samx".toRegex(RegexOption.IGNORE_CASE)

fun main() {
    val input = readInput("/day-4/input.txt") ?: ""
    val matrix = createMatrix(input)
    val rows = getRows(matrix)
    val cols = getCols(matrix)
    val diagonals = getDiagonals(matrix)
    val lines = rows + cols + diagonals.ltr + diagonals.bltr
    var totalMatches = 0
    for (line in lines) {
        val matches = getMatchCount(line)
        totalMatches += matches
    }
    println("Total Matches: ${totalMatches}")
}

fun createMatrix(input: String): Array<CharArray> {
    return input.lines().map { it.toCharArray() }.toTypedArray()
}

fun getRows(matrix: Array<CharArray>): List<String> {
    return matrix.map{ String(it) }
}

fun getCols(matrix: Array<CharArray>): List<String> {
    if (matrix.isEmpty()) return listOf()
    val results = mutableListOf<String>()
    val rows = matrix.size
    val cols = matrix[0].size
    for (col in 0 until cols) {
        val chars = mutableListOf<Char>()
        for (row in 0 until rows) {
            chars.add(matrix[row][col])
        }
        results.add(chars.joinToString(""))
    }
    return results
}

data class Diagonals(val ltr: List<String>, val bltr: List<String>)
fun getDiagonals(matrix: Array<CharArray>): Diagonals {
    if (matrix.isEmpty()) return Diagonals(listOf(), listOf())
    val dim = matrix.size
    if (matrix[0].size != dim) throw Error("Matrix is not square")
    val ltr = Array((2 * matrix.size) - 1) { mutableListOf<Char>() }
    val bltr = Array((2 * matrix.size) - 1) { mutableListOf<Char>() }
    for (row in 0 until dim) {
        for (col in 0 until dim) {
            ltr[col - row + (dim - 1)].add(matrix[row][col])
            bltr[row + col].add(matrix[row][col])
        }
    }
    return Diagonals(ltr.map { it.joinToString("")}, bltr.map { it.joinToString("") })
}

fun getMatchCount(line: String): Int {
    return xmasRegex.findAll(line).count() + samxRegex.findAll(line).count()
}