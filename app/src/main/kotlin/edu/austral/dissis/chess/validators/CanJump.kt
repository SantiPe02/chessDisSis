package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class CanJump: Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        var valid = false
        if (board.getPiece(movement.getFrom())!!.getType() == PieceType.KNIGHT){
            valid = true
        }
        return valid
    }
}