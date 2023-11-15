package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.structure.Board
import edu.austral.dissis.chess.structure.Game
import edu.austral.dissis.chess.structure.Movement
import edu.austral.dissis.chess.structure.Position

class CheckMateValidator {
    fun validate(game: Game): Boolean {
        val checkValidator = CheckValidator()
        if (!checkValidator.validate(game)) {
            return false
        }

        val kingPosition = findKingPosition(game.getActualBoard(), game.getTurn().getColor())
        for (dx in -1..1) {
            for (dy in -1..1) {
                if (dx == 0 && dy == 0) continue
                val newX = kingPosition.getX() + dx
                val newY = kingPosition.getY() + dy

                if (isValidMove(game, kingPosition, newX, newY)) {
                    return false
                }
            }
        }
        return true
    }

    private fun findKingPosition(board: Board, color: Color): Position {
        for (position in board.getPositions()) {
            if (position.getPiece() != null && position.getPiece()!!.getType() == PieceType.KING && position.getPiece()!!.getColor() == color) {
                return position
            }
        }
        throw IllegalStateException("King not found")
    }

    private fun isValidMove(game: Game, from: Position, toX: Int, toY: Int): Boolean {
        var valid = false
        try {
            val to = game.getActualBoard().getPositions()[toY * 8 + toX]
            val movement = Movement(game.getTurn(), from, to)
            val movementValidator = MovementValidator()
            if (movementValidator.validate(movement, game.getActualBoard())) {
                val newGame = game.action(movement)
                val checkValidator = CheckValidator()
                if (checkValidator.validate(newGame)) {
                    return false
                }
                valid = true
            }
        } catch (e: Exception) {
            print("Invalid move")
        }

        return valid
    }
}
