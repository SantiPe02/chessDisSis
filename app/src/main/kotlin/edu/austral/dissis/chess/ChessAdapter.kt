package edu.austral.dissis.chess

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.chess.structure.Game
import edu.austral.dissis.chess.structure.Movement
import edu.austral.dissis.chess.structure.Piece

class ChessAdapter: GameEngine {
    private var game = Game().initialState()
    override fun applyMove(move: Move): MoveResult {
        val from = game.getActualBoard().getPositions()[(move.from.row-1)*8+move.from.column-1]
        val to = game.getActualBoard().getPositions()[(move.to.row-1)*8+move.to.column-1]
        val movement = Movement(game.getTurn(), from, to)
        val newGame = game.action(movement)
        if (newGame.getValidators().isEmpty()){
            return GameOver(colorAdapter(game.getTurn().getColor()))
        }
        if (newGame == game){
            return InvalidMove("Invalid move")
        }
        game = newGame
        val pieces = pieceAdapter(game)
        val color = colorAdapter(game.getTurn().getColor())
        return NewGameState(pieces, color)
    }

    override fun init(): InitialState {
        return InitialState(BoardSize(8, 8), pieceAdapter(game), PlayerColor.WHITE)
    }

    private fun pieceAdapter(game: Game): List<ChessPiece>{
        val pieces = ArrayList<ChessPiece>()
        for (i in 0..7){
            for (j in 0..7){
                if (game.getActualBoard().getPositions()[i*8+j].getPiece() != null){
                    val piece = game.getActualBoard().getPositions()[i*8+j].getPiece()
                    val color = colorAdapter(piece!!.getColor())
                    val type = typeAdapter(piece)
                    val position = Position(i+1, j+1)
                    val id = piece.hashCode()
                    val chessPiece = ChessPiece(id.toString(), color, position, type)
                    pieces.add(chessPiece)

                }
            }
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
}