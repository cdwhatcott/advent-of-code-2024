package ten

import util.readInput

data class Position(val row: Int, val col: Int)
data class Tile(val value: Int, val position: Position)

fun main() {
    val input = readInput("/day-10/input.txt") ?: ""
    val matrix = createMatrix(input)
    val trailheads = getTrailheads(matrix)
    val scoreTotal = trailheads.map(Trailhead::getScore).fold(0) { a, b -> a + b }
    val ratingTotal = trailheads.map(Trailhead::getRating).fold(0) { a, b -> a + b }
    println("Score Total: $scoreTotal")
    println("Rating Total: $ratingTotal")
}

fun createMatrix(input: String): List<List<Int?>> {
    return input.lines().map { it.toCharArray() }.map { chars -> chars.map { c ->
        if (c.isDigit()) {
            c.digitToInt()
        } else {
            null
        }
    }}
}

fun getTrailheads(matrix: List<List<Int?>>): List<Trailhead> {
    val trailheads = mutableListOf<Trailhead>()

    val rowMax = matrix.size
    val colMax = matrix[0].size
    for (row in 0 until rowMax) {
        for (col in 0 until colMax) {
            val value = matrix[row][col]
            if (value != null && value == 0) {
                val tile = Tile(value, Position(row, col))
                val trailhead = Trailhead(matrix, tile)
                trailheads.add(trailhead)
            }
        }
    }

    return trailheads
}

class Trailhead(private val matrix: List<List<Int?>>, startTile: Tile) {

    private val endTiles = mutableListOf<Tile>()

    init {
        hike(startTile)
    }

    fun getScore(): Int {
        return endTiles.toSet().size
    }

    fun getRating(): Int {
        return endTiles.size
    }

    private fun hike(tile: Tile) {
        if (tile.value == 9) {
            endTiles.add(tile)
        } else {
            val north = if (tile.position.row > 0) matrix[tile.position.row - 1][tile.position.col] else null
            val east = if (tile.position.col < matrix[0].size - 1) matrix[tile.position.row][tile.position.col + 1] else null
            val south = if (tile.position.row < matrix.size - 1) matrix[tile.position.row + 1][tile.position.col] else null
            val west = if (tile.position.col > 0) matrix[tile.position.row][tile.position.col - 1] else null
            if (north == tile.value + 1) {
                hike(Tile(north, Position(tile.position.row - 1, tile.position.col)))
            }
            if (east == tile.value + 1) {
                hike(Tile(east, Position(tile.position.row, tile.position.col + 1)))
            }
            if (south == tile.value + 1) {
                hike(Tile(south, Position(tile.position.row + 1, tile.position.col)))
            }
            if (west == tile.value + 1) {
                hike(Tile(west, Position(tile.position.row, tile.position.col - 1)))
            }
        }
    }
}