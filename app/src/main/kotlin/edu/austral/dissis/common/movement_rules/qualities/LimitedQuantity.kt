package edu.austral.dissis.common.movement_rules.qualities

import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import kotlin.math.abs

class LimitedQuantity(private val qty: Int): MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (abs(movement.getFrom().getRow() - movement.getTo().getRow()) <= qty && abs(movement.getFrom().getColumn() - movement.getTo().getColumn()) <= qty){
            return ValidResult()
        }
        return InvalidResult("Invalid movement: not limited quantity")
    }
}