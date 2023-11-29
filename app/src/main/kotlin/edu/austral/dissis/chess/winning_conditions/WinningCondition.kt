package edu.austral.dissis.chess.winning_conditions

import edu.austral.dissis.common.structure.Game

interface WinningCondition {
    fun validate(game: Game): Boolean
}