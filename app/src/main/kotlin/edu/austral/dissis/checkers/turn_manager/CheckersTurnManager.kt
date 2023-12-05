package edu.austral.dissis.checkers.turn_manager

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.turn_manager.TurnManager

class CheckersTurnManager: TurnManager {
    override fun switchTurn(color: Color, board: Board): Color {
        return if (color == Color.WHITE) Color.BLACK else Color.WHITE
    }
}