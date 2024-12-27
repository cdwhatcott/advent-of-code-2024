package six

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DaySixTest {

    @Test
    fun shouldVisit41() {
        val input = """
            ....#.....
            .........#
            ..........
            ..#.......
            .......#..
            ..........
            .#..^.....
            ........#.
            #.........
            ......#...
        """.trimIndent()
        val room = Room(input.lines())
        room.run()
        val distinctPositions = room.guards.map { guard -> guard.positionHistory.toSet().size }.reduce { a, b -> a + b}
        assertEquals(distinctPositions, 41)
    }
}