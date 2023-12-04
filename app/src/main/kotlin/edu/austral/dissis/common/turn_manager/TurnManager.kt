package edu.austral.dissis.common.turn_manager

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.structure.Board

interface TurnManager {
    fun switchTurn(color: Color, board: Board): Color
}