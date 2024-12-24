package four

import util.readInput

fun main() {
    val input = readInput("/day-4/input.txt") ?: ""
    val matrix = createMatrix(input)
    val count = getXmasCount(matrix)
    println("X-MAS count: $count")
}

fun getXmasCount(matrix: Array<CharArray>): Int {
    var count = 0
    val rowMax = matrix.size
    val colMax = matrix[0].size
    // start at 1 and stop at row/col - 1 since we won't be able to find an X-mas around the edges of the matrix
    for (row in 1 until (rowMax - 1)) {
        for (col in 1 until (colMax - 1)) {
            if (matrix[row][col] == 'A') {
                // get the chars surrounding the A
                val tl = matrix[row - 1][col - 1]
                val tr = matrix[row - 1][col + 1]
                val bl = matrix[row + 1][col - 1]
                val br = matrix[row + 1][col + 1]
                if (((tl == 'M' && br == 'S') || (tl == 'S' && br == 'M'))
                    && ((bl == 'M' && tr == 'S') || (bl == 'S' && tr == 'M'))) {
                    count++
                }
            }
        }
    }
    return count
}