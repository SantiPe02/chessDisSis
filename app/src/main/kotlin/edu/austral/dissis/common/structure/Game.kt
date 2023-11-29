package edu.austral.dissis.common.structure

import edu.austral.dissis.common.results.CanMoveResult
import edu.austral.dissis.common.results.GameOverResult
import edu.austral.dissis.common.results.InvalidMovement
import edu.austral.dissis.common.results.MoveResult
import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.validators.*
import edu.austral.dissis.chess.winning_conditions.WinningCondition

class Game(
    private var actualBoard: Board,
    private var movements: Array<Board>,
    private var turn: Color,
    private var validators: Array<Validator>,
    private var winningConditions: Array<WinningCondition>,
) {

    fun action(movement: Movement): MoveResult {
        if (canMove(movement)) {
            val newBoard = actualBoard.makeMove(movement.getFrom(), movement.getTo())
            val newMovements = movements + actualBoard
            val newGame = Game(newBoard, newMovements, switchTurn(), validators, winningConditions)
            if (gameOver(newGame)) {
                return GameOverResult(turn)
            }
            return CanMoveResult(newGame)
        }
        return InvalidMovement("Invalid movement")
    }

    private fun canMove(movement: Movement): Boolean {
        return validatePieceRules(movement) && validateValidators(movement)
    }

    private fun validatePieceRules(movement: Movement): Boolean {
        val piece = actualBoard.getPiece(movement.getFrom()) ?: return false
        val pieceMovementRules = piece.getRules()
        for (rule in pieceMovementRules) {
            if (rule.validate(movement, actualBoard)) {
                return true
            }
        }
        return false
    }

    private fun validateValidators(movement: Movement): Boolean {
        for (validator in validators) {
            if (!validator.validate(movement, actualBoard)) {
                return false
            }
        }
        return true
    }

    private fun gameOver(game: Game): Boolean {
        for (winningCondition in winningConditions) {
            if (winningCondition.validate(game)) {
                return true
            }
        }
        return false
    }

    private fun switchTurn(): Color{
        val newTurn = if (turn == Color.WHITE) {
            Color.BLACK
        } else {
            Color.WHITE
        }
        return newTurn
    }

    fun getActualBoard(): Board {
        return actualBoard
    }

    fun getMovements(): Array<Board> {
        return movements
    }

    fun getTurn(): Color {
        return turn
    }

    fun getValidators(): Array<Validator> {
        return validators
    }

    fun getWinningConditions(): Array<WinningCondition> {
        return winningConditions
    }
}
