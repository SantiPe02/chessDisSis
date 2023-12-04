package edu.austral.dissis.common.util

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

fun validatePromotion(movement: Movement, board: Board): Boolean {
    val piece = board.getPiece(movement.getFrom())
    if (piece!!.getType() != PieceType.PAWN) {
        return false
    }

    val pieceColor = piece.getColor()

    if (pieceColor == Color.WHITE){
        if (movement.getTo().getRow() == board.getRow()){
            return true
        }
    }
    else{
        if (movement.getTo().getRow() == 1){
            return true
        }
    }
    return false
}