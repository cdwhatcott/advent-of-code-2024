package six

import util.readInput

fun main() {
    val input = readInput("/day-6/input.txt") ?: ""
    val room = Room(input.lines())
    room.run()
    val distinctPositions = room.guards.map { guard -> guard.positionHistory.toSet().size }.reduce { a, b -> a + b}
    println("Distinct positions: $distinctPositions")
}

data class Position(val x: Int, val y: Int)
class Guard(var position: Position, private var rotation: Int) {

    val positionHistory = mutableListOf<Position>()

    private fun turn() {
        rotation = when(rotation) {
            0 -> 90
            90 -> 180
            180 -> 270
            else -> 0
        }
    }

    fun move(obstructions: Set<Position>) {
        val newPosition = when(rotation) {
            0 -> Position(position.x, position.y - 1)
            90 -> Position(position.x + 1, position.y)
            180 -> Position(position.x, position.y + 1)
            else -> Position(position.x - 1, position.y)
        }
        if (obstructions.contains(newPosition)) {
            turn()
            move(obstructions)
        } else {
            positionHistory.add(position)
            position = newPosition
        }
    }
}

class Room(input: List<String>) {

    private val width: Int = input[0].length
    private val height: Int = input.size
    val guards = mutableListOf<Guard>()
    private val obstructions = mutableSetOf<Position>()

    init {
        input.forEachIndexed { row, line ->
            val chars = line.toCharArray()
            chars.forEachIndexed { col, char ->
                run {
                    if (char == '#') {
                        obstructions.add(Position(col, row))
                    } else if (char == '^') {
                        guards.add(Guard(Position(col, row), 0))
                    }
                }
            }
        }
    }

    fun run () {
        var run: Boolean
        do {
            guards.filter { guard -> isGuardInRoom(guard) }.forEach { guard -> guard.move(obstructions) }
            // stop running once all guards have left the room
            run = guards.any { guard -> isGuardInRoom(guard) }
        } while (run)
    }

    private fun isGuardInRoom(guard: Guard): Boolean {
        return guard.position.x > -1 && guard.position.x < width && guard.position.y > -1 && guard.position.y < height
    }
}