package edu.austral.dissis.common.validators

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class MovementValidator : Validator {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (!board.getPositions().containsKey(movement.getFrom())) {
            return InvalidResult("Invalid movement: no piece selected")
        }
        if (movement.getFrom().getRow() == movement.getTo().getRow() && movement.getFrom().getColumn() == movement.getTo().getColumn()) {
            return InvalidResult("Invalid movement: same position")
        }
        if (board.getPositions().containsKey(movement.getTo()) &&  board.getPiece(movement.getFrom())!!.getColor() == board.getPiece(movement.getTo())!!.getColor()){
            return InvalidResult("Invalid movement: same team")
        }
        return ValidResult()
    }
}