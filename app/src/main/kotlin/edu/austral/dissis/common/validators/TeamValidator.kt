package edu.austral.dissis.common.validators

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class TeamValidator : Validator {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (board.getPiece(movement.getFrom()) == null) return InvalidResult("Invalid movement: no piece selected")
        if (board.getPiece(movement.getFrom())!!.getColor() == movement.getTurn()) {
            return ValidResult()
        }
        return InvalidResult("Invalid movement: wrong team")
    }
}