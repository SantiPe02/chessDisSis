package edu.austral.dissis.common.movement_rules

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class AndRule(private val ruleList: List<MovementRule>): MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        for (rule in ruleList) {
            if (rule.validate(movement, board) is InvalidResult) {
                return InvalidResult("Invalid movement: not vertical")
            }
        }
        return ValidResult()
    }
}