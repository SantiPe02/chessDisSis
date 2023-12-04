package edu.austral.dissis.common.movement_rules.qualities

import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement


class HasMoved: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (board.getPiece(movement.getFrom())!!.getHasMoved()){
            return InvalidResult("Invalid movement: piece has already moved")
        }
        return ValidResult()
    }
}