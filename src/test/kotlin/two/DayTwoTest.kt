package two

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DayTwoTest {

    @Test
    fun shouldBeSafe() {
        val report1 = mutableListOf(7, 6, 4, 2, 1)
        val report2 = mutableListOf(1, 3, 6, 7, 9)
        val report4 = mutableListOf(8, 6, 4, 1)
        assertTrue { isSafe(report1) }
        assertTrue { isSafe(report2) }
        assertTrue { isSafe(report4) }
    }

    @Test
    fun shouldBeUnsafe() {
        val report1 = mutableListOf(1, 2, 7, 8, 9)
        val report2 = mutableListOf(9, 7, 6, 2, 1)
        assertFalse { isSafe(report1) }
        assertFalse { isSafe(report2) }

    }
}