package edu.austral.dissis.checkers.turn_manager

import edu.austral.dissis.checkers.util.possibilityToEat
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.turn_manager.TurnManager

class CheckersTurnManager: TurnManager {
    override fun switchTurn(game: Game, newBoard: Board): Color {
        val color = game.getTurn()
        val oppositeColor = oppositeColor(color)
        val actualBoard = game.getActualBoard()

        if (canContinueEating(actualBoard, newBoard, color)) return color

        return oppositeColor
    }

    private fun oppositeColor(color: Color): Color {
        return if (color == Color.WHITE) Color.BLACK else Color.WHITE
    }

    private fun canContinueEating(board: Board, newBoard: Board, color: Color): Boolean {
        return possibilityToEat(board, color) && possibilityToEat(newBoard, color)
    }
}