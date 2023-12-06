package edu.austral.dissis.app

import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.results.move_results.CanMoveResult
import edu.austral.dissis.common.results.move_results.GameOverResult
import edu.austral.dissis.common.results.move_results.InvalidMovement
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Piece

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
        return InitialState(BoardSize(8, 8), pieceAdapter(), PlayerColor.WHITE)
    }

    private fun pieceAdapter(): List<ChessPiece>{
        val pieces = ArrayList<ChessPiece>()
        val board = game.getActualBoard()
        board.getPositions().forEach {
            pieces.add(ChessPiece(it.value.getId(), colorAdapter(it.value.getColor()), Position(it.key.getRow(), it.key.getColumn()), typeAdapter(it.value)))
        }
        return pieces
    }

    private fun colorAdapter(color: Color): PlayerColor{
        return when(color){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
    }
    private fun typeAdapter(piece: Piece?): String{
        return when(piece!!.getType()){
            PieceType.PAWN -> "pawn"
            PieceType.ROOK -> "rook"
            PieceType.KNIGHT -> "knight"
            PieceType.BISHOP -> "bishop"
            PieceType.QUEEN -> "queen"
            PieceType.KING -> "king"
        }
    }

    private fun updateGame(result: CanMoveResult): MoveResult{
        game = result.game
        return NewGameState(pieceAdapter(), colorAdapter(game.getTurn()))
    }
}