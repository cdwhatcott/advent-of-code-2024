package four

import util.readInput

val xmasRegex = "xmas|samx".toRegex(RegexOption.IGNORE_CASE)

fun main() {
    val input = readInput("/day-4/input.txt") ?: ""
    val matrix = createMatrix(input)
    val rows = getRows(matrix)
    val cols = getCols(matrix)
    println("Rows:")
    for (row in rows) {
        println(row)
        val matches = getMatchCount(row)
        println("Matches: $matches")
    }
    println("Cols:")
    for (col in cols) {
        println(col)
        val matches = getMatchCount(col)
        println("Matches: $matches")
    }
    // TODO need to get diagonals
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

fun getMatchCount(line: String): Int {
    return xmasRegex.findAll(line).count()
}