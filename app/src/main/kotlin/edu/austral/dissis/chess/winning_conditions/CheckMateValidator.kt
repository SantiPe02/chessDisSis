package edu.austral.dissis.chess.winning_conditions

import edu.austral.dissis.common.structure.Game

class CheckMateValidator: WinningCondition {
    override fun validate(game: Game): Boolean {
        return false
    }
}
