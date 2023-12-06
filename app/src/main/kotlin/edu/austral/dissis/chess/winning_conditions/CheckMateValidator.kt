package edu.austral.dissis.chess.winning_conditions

import edu.austral.dissis.common.util.getAllPossiblePieceMovements
import edu.austral.dissis.chess.util.getPossibleKingMoves
import edu.austral.dissis.chess.validators.NotInCheck
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.winning_conditions.WinningCondition

class CheckMateValidator: WinningCondition {
    override fun validate(game: Game): ValidationResult {
        val possibleKingMoves = getPossibleKingMoves(game.getActualBoard(), game.getTurn())
        val possibleTeamMovements = getAllPossiblePieceMovements(game.getTurn(), game.getActualBoard())
        if (possibleKingMoves.isEmpty()){
            return InvalidResult("No Checkmate")
        }
        for (movement in possibleKingMoves){
            if (NotInCheck().validate(movement, game.getActualBoard()) is ValidResult){
                return InvalidResult("No Checkmate")
            }
        }
        for (move in possibleTeamMovements){
            if (NotInCheck().validate(move, game.getActualBoard()) is ValidResult){
                return InvalidResult("No Checkmate")
            }
        }
        return ValidResult()
    }
}
