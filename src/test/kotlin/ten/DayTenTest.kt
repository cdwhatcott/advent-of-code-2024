package ten

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DayTenTest {

    @Test
    fun shouldScoreTwo() {
        val twoTrails = """
            ...0...
            ...1...
            ...2...
            6543456
            7.....7
            8.....8
            9.....9
        """.trimIndent()

        val matrix = createMatrix(twoTrails)
        val trailheads = getTrailheads(matrix)
        val score = trailheads.map { t -> t.getScore() }.fold(0) { a, b -> a + b }
        assertEquals(2, score)
    }

    @Test
    fun shouldScoreFour() {
        val fourTrails = """
            ..90..9
            ...1.98
            ...2..7
            6543456
            765.987
            876....
            987....
        """.trimIndent()
        val matrix = createMatrix(fourTrails)
        val trailheads = getTrailheads(matrix)
        val score = trailheads.map { t -> t.getScore() }.fold(0) { a, b -> a + b }
        assertEquals(4, score)
    }

    @Test
    fun shouldScoreThreeWithTwoTrailheads() {
        val threeTrails = """
            10..9..
            2...8..
            3...7..
            4567654
            ...8..3
            ...9..2
            .....01
        """.trimIndent()
        val matrix = createMatrix(threeTrails)
        val trailheads = getTrailheads(matrix)
        val score = trailheads.map { t -> t.getScore() }.fold(0) { a, b -> a + b }
        assertEquals(3, score)
    }

    @Test
    fun shouldScoreThirtySixWithNineTrailheads() {
        val thirtySix = """
            89010123
            78121874
            87430965
            96549874
            45678903
            32019012
            01329801
            10456732
        """.trimIndent()

        val matrix = createMatrix(thirtySix)
        val trailheads = getTrailheads(matrix)
        val score = trailheads.map { t -> t.getScore() }.fold(0) { a, b -> a + b }
        assertEquals(36, score)
    }

    // part two
    @Test
    fun shouldRateThree() {
        val three = """
            .....0.
            ..4321.
            ..5..2.
            ..6543.
            ..7..4.
            ..8765.
            ..9....
        """.trimIndent()

        val matrix = createMatrix(three)
        val trailheads = getTrailheads(matrix)
        val rating = trailheads.map { t -> t.getRating() }.fold(0) { a, b -> a + b }
        assertEquals(3, rating)
    }

    @Test
    fun shouldRateThirteen() {
        val thirteen = """
            ..90..9
            ...1.98
            ...2..7
            6543456
            765.987
            876....
            987....
        """.trimIndent()

        val matrix = createMatrix(thirteen)
        val trailheads = getTrailheads(matrix)
        val rating = trailheads.map { t -> t.getRating() }.fold(0) { a, b -> a + b }
        assertEquals(13, rating)
    }

    @Test
    fun shouldRate227() {
        val twoTwoSeven = """
            012345
            123456
            234567
            345678
            4.6789
            56789.
        """.trimIndent()

        val matrix = createMatrix(twoTwoSeven)
        val trailheads = getTrailheads(matrix)
        val rating = trailheads.map { t -> t.getRating() }.fold(0) { a, b -> a + b }
        assertEquals(227, rating)
    }
}