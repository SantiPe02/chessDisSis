package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.structure.Movement

class CanJump {
    fun validate(movement: Movement): Boolean {
        val piece = movement.getFrom().getPiece()
        return piece?.getType() == PieceType.KNIGHT
    }
}