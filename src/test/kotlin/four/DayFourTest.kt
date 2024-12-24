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
        // TODO need to get diagonals
        val lines = rows + cols
        for (line in lines) {
            val lineMatches = getMatchCount(line)
            matches += lineMatches
        }
        assertEquals(18, matches)
    }
}