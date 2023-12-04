package edu.austral.dissis.common.validators

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class InBoundsValidator : Validator {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (movement.getFrom().getRow() < 1 || movement.getFrom().getRow() > board.getRow()) {
            return InvalidResult("Invalid movement: Out of bounds")
        }
        if (movement.getTo().getRow() < 1 || movement.getTo().getRow() > board.getRow()) {
            return InvalidResult("Invalid movement: Out of bounds")
        }
        if (movement.getFrom().getColumn() < 1 || movement.getFrom().getColumn() > board.getCol()) {
            return InvalidResult("Invalid movement: Out of bounds")
        }
        if (movement.getTo().getColumn() < 1 || movement.getTo().getColumn() > board.getCol()) {
            return InvalidResult("Invalid movement: Out of bounds")
        }
        return ValidResult()
    }
}