package edu.austral.dissis.common.turn_manager

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Game

interface TurnManager {
    fun switchTurn(game: Game, newBoard: Board): Color
}