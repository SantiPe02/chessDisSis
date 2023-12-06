package edu.austral.dissis.common.util

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Piece

fun validatePromotion(movement: Movement, board: Board): Boolean {
    val piece = board.getPiece(movement.getFrom())
    if (notPawn(piece!!)) {
        return false
    }

    val pieceColor = piece.getColor()

    if (isWhite(pieceColor)) {
        if (movement.getTo().getRow() == board.getRow()){
            return true
        }
    }
    if(isBlack(pieceColor)){
        if (movement.getTo().getRow() == 1){
            return true
        }
    }
    return false
}

private fun notPawn(piece: Piece): Boolean {
    return piece.getType() != PieceType.PAWN
}

private fun isWhite(color: Color): Boolean {
    return color == Color.WHITE
}

private fun isBlack(color: Color): Boolean {
    return color == Color.BLACK
}