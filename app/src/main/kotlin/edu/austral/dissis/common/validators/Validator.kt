package edu.austral.dissis.common.validators

import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

interface Validator {
    fun validate(movement: Movement, board: Board): ValidationResult
}