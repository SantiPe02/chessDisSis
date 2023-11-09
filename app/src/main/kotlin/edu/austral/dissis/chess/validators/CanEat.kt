package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.structure.Movement

object CanEat {
    fun validate(movement: Movement): Boolean {
        if (movement.getTo().getPiece() == null) return false
        if (movement.getFrom().getPiece()!!.getColor() == movement.getTo().getPiece()!!.getColor()) throw IllegalStateException("Can't eat your own piece")
        return movement.getFrom().getPiece()!!.getColor() != movement.getTo().getPiece()!!.getColor()
    }
}