package edu.austral.dissis.common.movement_rules.orientation

import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class VerticalMove: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult{
        if (movement.getFrom().getColumn() == movement.getTo().getColumn()) {
            return ValidResult()
        }
        return InvalidResult("Invalid movement: not vertical")
    }
}