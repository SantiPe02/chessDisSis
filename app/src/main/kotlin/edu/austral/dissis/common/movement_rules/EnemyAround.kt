package edu.austral.dissis.common.movement_rules

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position

class EnemyAround: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        val from = movement.getFrom()
        val to = movement.getTo()
        if (isEnemy(from, to, board)) {
            return ValidResult()
        }
        return InvalidResult("Invalid movement: no enemy around")
    }

    private fun isEnemy(from: Position, to: Position, board: Board): Boolean {
        return board.getPiece(to) != null && board.getPiece(to)?.getColor() != board.getPiece(from)?.getColor()
    }
}