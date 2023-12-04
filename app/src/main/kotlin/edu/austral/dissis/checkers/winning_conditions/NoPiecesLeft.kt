package edu.austral.dissis.checkers.winning_conditions

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.winning_conditions.WinningCondition

class NoPiecesLeft: WinningCondition {
    override fun validate(game: Game): ValidationResult {
        val board = game.getActualBoard()

        if (board.getWhitePieces().isEmpty()){
            return ValidResult()
        }
        if (board.getBlackPieces().isEmpty()){
            return ValidResult()
        }
        return InvalidResult("Still pieces left")
    }
}