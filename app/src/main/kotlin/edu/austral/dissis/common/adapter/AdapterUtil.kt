package edu.austral.dissis.common.adapter

import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.gui.PlayerColor
import edu.austral.dissis.chess.gui.Position
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.structure.Piece

fun pieceAdapter(game: Game): List<ChessPiece>{
    val pieces = ArrayList<ChessPiece>()
    val board = game.getActualBoard()
    board.getPositions().forEach {
        pieces.add(ChessPiece(it.value.getId(), colorAdapter(it.value.getColor()), Position(it.key.getRow(), it.key.getColumn()), typeAdapter(it.value)))
    }
    return pieces
}

fun colorAdapter(color: Color): PlayerColor {
    return when(color){
        Color.WHITE -> PlayerColor.WHITE
        Color.BLACK -> PlayerColor.BLACK
    }
}
fun typeAdapter(piece: Piece?): String{
    return when(piece!!.getType()){
        PieceType.PAWN -> "pawn"
        PieceType.ROOK -> "rook"
        PieceType.KNIGHT -> "knight"
        PieceType.BISHOP -> "bishop"
        PieceType.QUEEN -> "queen"
        PieceType.KING -> "king"
        PieceType.ARCHBISHOP -> "archbishop"
        PieceType.CHANCELLOR -> "chancellor"
    }
}