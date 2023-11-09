package edu.austral.dissis.chess.structure


class Position(private val x: Int, private val y: Int, private val piece: Piece?) {
    fun getX(): Int {
        return x
    }

    fun getY(): Int {
        return y
    }

    fun getPiece(): Piece? {
        return piece
    }
}
