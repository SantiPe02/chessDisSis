package edu.austral.dissis.checkers.winning_conditions

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.winning_conditions.WinningCondition

class NoPossibleMovement: WinningCondition {
    override fun validate(game: Game): ValidationResult {
        return InvalidResult("No possible movement")
    }
}