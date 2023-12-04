package edu.austral.dissis.common.winning_conditions

import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Game

interface WinningCondition {
    fun validate(game: Game): ValidationResult
}