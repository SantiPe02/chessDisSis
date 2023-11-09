package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.structure.Board
import edu.austral.dissis.chess.structure.Game
import edu.austral.dissis.chess.structure.Movement
import edu.austral.dissis.chess.structure.Position

class CheckValidator {
    fun validate(game: Game): Boolean {
        val kingPosition = findKingPosition(game.getActualBoard(), game.getTurn().getColor())
        val opponentColor = if (game.getTurn().getColor() == Color.WHITE) Color.BLACK else Color.WHITE

        for (position in game.getActualBoard().getPositions()) {
            if (position.getPiece() != null && position.getPiece()!!.getColor() == opponentColor) {
                val enemyMovement = Movement(game.getTurn(), position, kingPosition)
                val movementValidator = MovementValidator()

                if (movementValidator.validate(enemyMovement, game.getActualBoard()) && InBetweenPieceValidator().validate(enemyMovement, game.getActualBoard())){
                    return true
                }
            }
        }

        return false
    }

    private fun findKingPosition(board: Board, color: Color): Position {
        for (position in board.getPositions()) {
            if (position.getPiece() != null && position.getPiece()!!.getType() == PieceType.KING && position.getPiece()!!.getColor() == color) {
                return position
            }
        }
        throw IllegalStateException("King not found")
    }
}