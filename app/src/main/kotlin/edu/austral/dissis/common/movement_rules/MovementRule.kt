package edu.austral.dissis.common.movement_rules

import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

interface MovementRule {
    fun validate(movement: Movement, board: Board): ValidationResult
}