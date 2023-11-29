package edu.austral.dissis.common.structure


class Board(private var positions: Map<Position, Piece>, private val row: Int, private val col: Int) {

    fun makeMove(from: Position, to: Position): Board {
        if(!positions.containsKey(from)) return this
        val piece = positions[from]!!
        return Board(positions + Pair(to, piece.copy(
            hasMoved = true
        )) - from, row, col)
    }

    fun getPositions(): Map<Position, Piece> {
        return positions
    }

    fun getPiece(position: Position): Piece? {
        return positions[position]
    }

    fun getPieceAt(x: Int, y: Int): Piece? {
        return positions[Position(x, y)]
    }

    fun getRow(): Int {
        return row
    }

    fun getCol(): Int {
        return col
    }
}
