package edu.austral.dissis.common.structure

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.movement_rules.MovementRule

data class Piece(
    private val id: String,
    private val color: Color,
    private val type: PieceType,
    private val rules: ArrayList<MovementRule>,
    private var hasMoved: Boolean
    ){

    fun getColor(): Color {
        return color
    }

    fun getType(): PieceType {
        return type
    }

    fun getHasMoved(): Boolean {
        return hasMoved
    }

    fun getId(): String {
        return id
    }

    fun getRules(): ArrayList<MovementRule> {
        return rules
    }
}