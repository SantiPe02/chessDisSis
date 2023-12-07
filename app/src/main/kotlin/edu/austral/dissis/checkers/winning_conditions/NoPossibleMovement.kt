package edu.austral.dissis.checkers.winning_conditions

import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.util.getAllPossiblePieceMovements
import edu.austral.dissis.common.winning_conditions.WinningCondition

class NoPossibleMovement: WinningCondition {
    override fun validate(game: Game): ValidationResult {
        for ((_, piece) in game.getActualBoard().getPositions()){
            if (piece.getColor() == game.getTurn()){
                val movements = getAllPossiblePieceMovements(piece.getColor(), game.getActualBoard())
                if (movements.isNotEmpty()) return InvalidResult("There are possible movements")
            }
        }
        return ValidResult()
    }
}