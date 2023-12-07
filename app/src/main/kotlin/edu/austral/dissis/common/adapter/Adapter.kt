package edu.austral.dissis.common.adapter

import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.common.results.move_results.CanMoveResult
import edu.austral.dissis.common.results.move_results.GameOverResult
import edu.austral.dissis.common.results.move_results.InvalidMovement
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.structure.Movement

class Adapter(private var game: Game): GameEngine {

    override fun applyMove(move: Move): MoveResult {
        val from = edu.austral.dissis.common.structure.Position(move.from.row, move.from.column)
        val to = edu.austral.dissis.common.structure.Position(move.to.row, move.to.column)
        val movement = Movement(from, to, game.getTurn(), game.getActualBoard())
        return when (val result = game.action(movement)){
            is CanMoveResult -> updateGame(result)
            is GameOverResult -> GameOver(colorAdapter(result.getWinner()))
            is InvalidMovement -> InvalidMove(result.getReason())
        }
    }

    override fun init(): InitialState {
        return InitialState(BoardSize(game.getActualBoard().getCol(), game.getActualBoard().getRow()), pieceAdapter(game), PlayerColor.WHITE)
    }

    private fun updateGame(result: CanMoveResult): MoveResult{
        game = result.game
        return NewGameState(pieceAdapter(game), colorAdapter(game.getTurn()))
    }
}