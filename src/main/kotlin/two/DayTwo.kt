package two

import util.readInput
import kotlin.math.abs
import kotlin.system.exitProcess

fun main() {
    val lines = readInput("/day-2/part-one-input.txt")?.lines()
    if (lines.isNullOrEmpty()) {
        println("Problem with input")
        exitProcess(1)
    }
    val reports = mutableListOf<List<Int>>()
    for (line: String in lines) {
        val levels = line.split("\\s+".toRegex()).map { s -> s.toInt() }
        reports.add(levels)
    }
    var safeReports = 0
    for (report in reports) {
        if (isSafe(report)) {
            safeReports++
        }
    }
    println("SAFE REPORTS ${safeReports}")
}

fun isSafe(report: List<Int>): Boolean {
    var prevValue: Int? = null
    var prevState: String? = null
    for (currValue in report) {
        if (prevValue != null) {
            val diff = currValue - prevValue
            if (diff == 0 || abs(diff) > 3) {
                // unsafe
                return false
            }
            val currState = when (diff > 0) {
                true -> "increasing"
                false -> "decreasing"
            }
            if (prevState != null && currState != prevState) {
                // unsafe
                return false
            }
            prevState = currState
        }
        prevValue = currValue

    }
    return true
}
