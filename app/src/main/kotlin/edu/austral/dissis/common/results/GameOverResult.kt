package edu.austral.dissis.common.results

import edu.austral.dissis.chess.enums.Color

class GameOverResult(private val winner: Color): MoveResult {
    fun getWinner(): Color {
        return winner
    }
}