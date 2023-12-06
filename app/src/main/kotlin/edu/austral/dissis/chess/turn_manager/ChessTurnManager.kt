package edu.austral.dissis.chess.turn_manager

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.turn_manager.TurnManager

class ChessTurnManager: TurnManager {
    override fun switchTurn(game: Game, newBoard: Board): Color {
        return if (isWhite(game)) Color.BLACK else Color.WHITE
    }

    private fun isWhite(game: Game): Boolean {
        return game.getTurn() == Color.WHITE
    }
}