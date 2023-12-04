package edu.austral.dissis.common.structure

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.ValidResult

data class Piece(
    private val id: String,
    private val color: Color,
    private val type: PieceType,
    private val rules: MovementRule,
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

    fun getRules(): MovementRule {
        return rules
    }

    fun getPossibleMovements(board: Board): List<Movement> {
        val movements = mutableListOf<Movement>()
        for (i in 1 until board.getRow()){
            for (j in 1 until board.getCol()){
                val movement = Movement(Position(i, j), Position(i, j), color, board)
                if (rules.validate(movement, board) is ValidResult) movements.add(movement)
            }
        }
        return movements
    }
}