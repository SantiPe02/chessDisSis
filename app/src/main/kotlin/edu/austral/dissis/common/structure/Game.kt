package edu.austral.dissis.common.structure

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.mover.Mover
import edu.austral.dissis.common.results.move_results.CanMoveResult
import edu.austral.dissis.common.results.move_results.GameOverResult
import edu.austral.dissis.common.results.move_results.InvalidMovement
import edu.austral.dissis.common.results.move_results.MoveResult
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.turn_manager.TurnManager
import edu.austral.dissis.common.validators.Validator
import edu.austral.dissis.common.winning_conditions.WinningCondition

class Game(
    private var actualBoard: Board,
    private var movements: Array<Movement>,
    private var turn: Color,
    private var validators: Array<Validator>,
    private var winningConditions: Array<WinningCondition>,
    private var turnManager: TurnManager,
    private var movers: List<Mover>
) {

    fun action(movement: Movement): MoveResult {
        if (validateValidators(movement)) {
            val newBoard = move(movement, actualBoard)
            if (validatePieceRules(movement)) {
                val newMovements = movements + movement
                val newGame =
                    Game(newBoard, newMovements, switchTurn(), validators, winningConditions, turnManager, movers)
                if (gameOver(newGame)) {
                    return GameOverResult(turn)
                }
                return CanMoveResult(newGame)
            }
        }
        return InvalidMovement("Invalid movement")
    }

    private fun canMove(movement: Movement): Boolean {
        return validatePieceRules(movement) && validateValidators(movement)
    }

    private fun validatePieceRules(movement: Movement): Boolean {
        val piece = actualBoard.getPiece(movement.getFrom()) ?: return false
        return when (val result = piece.getRules().validate(movement, actualBoard)) {
                is InvalidResult -> false
                is ValidResult -> true
            else -> {
                false
            }
        }
    }

    private fun validateValidators(movement: Movement): Boolean {
        for (validator in validators) {
            when (validator.validate(movement, actualBoard)) {
                is ValidResult -> continue
                is InvalidResult -> return false
            }
        }
        return true
    }

    private fun move(movement: Movement, board: Board): Board{
        for (mover in movers){
            if (mover.validate(movement, board)){
                return mover.move(movement, board)
            }
        }
        return actualBoard
    }

    private fun gameOver(game: Game): Boolean {
        for (winningCondition in winningConditions) {
            if (winningCondition.validate(game) is ValidResult) {
                return true
            }
        }
        return false
    }

    private fun switchTurn(): Color {
        return turnManager.switchTurn(this.getTurn(), actualBoard)
    }

    fun getActualBoard(): Board {
        return actualBoard
    }

    fun getMovements(): Array<Movement> {
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
