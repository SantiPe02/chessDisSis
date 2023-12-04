package edu.austral.dissis.common.movement_rules

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class NoEnemyAround: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (hasEnemy(movement)) {
            return InvalidResult("Invalid movement: enemy around")
        }
        return ValidResult()
    }

    private fun hasEnemy(movement: Movement): Boolean {
        return movement.getBoard().getPiece(movement.getTo()) != null && movement.getBoard().getPiece(movement.getTo())?.getColor() != movement.getBoard().getPiece(movement.getFrom())?.getColor()
    }
}