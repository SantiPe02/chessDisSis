package edu.austral.dissis.checkers.validators

import edu.austral.dissis.checkers.factory.specific_rules.IsEating
import edu.austral.dissis.checkers.util.canContinueEating
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.validators.Validator

class HasToEat: Validator {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (IsEating().validate(movement, board) is ValidResult) return ValidResult()
        if (canContinueEating(board, movement.getTurn())) return InvalidResult("You have to eat")
        return ValidResult()
    }
}