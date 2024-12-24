package four

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DayFourTest {

    val testInput = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
    """.trimIndent()

    @Test
    fun shouldFind18() {
        val matrix = createMatrix(testInput)
        var matches = 0
        val rows = getRows(matrix)
        val cols = getCols(matrix)
        val diagonals = getDiagonals(matrix)
        val lines = rows + cols + diagonals.ltr + diagonals.bltr
        for (line in lines) {
            val lineMatches = getMatchCount(line)
            matches += lineMatches
        }
        assertEquals(18, matches)
    }
}