package edu.austral.dissis.common.movement_rules.qualities

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class OnlyForwardMovement: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (movement.getTurn() == Color.WHITE && movement.getFrom().getRow() < movement.getTo().getRow()) {
            return ValidResult()
        }
        if (movement.getTurn() == Color.BLACK && movement.getFrom().getRow() > movement.getTo().getRow()) {
            return ValidResult()
        }
        return InvalidResult("Invalid movement: not forward")
    }

}