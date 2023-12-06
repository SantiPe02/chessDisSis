package edu.austral.dissis.common.results.move_results

import edu.austral.dissis.common.enums.Color

data class GameOverResult(private val winner: Color): MoveResult {
    fun getWinner(): Color {
        return winner
    }
}