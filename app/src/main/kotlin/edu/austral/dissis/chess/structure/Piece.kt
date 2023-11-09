package edu.austral.dissis.chess.structure

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType

class Piece(private val color: Color, private val type: PieceType) {
    private var hasMoved: Boolean = false

    fun getColor(): Color {
        return color
    }

    fun getType(): PieceType {
        return type
    }

    fun hasMoved(): Boolean {
        return hasMoved
    }

    fun setHasMoved() {
        hasMoved = true
    }
}