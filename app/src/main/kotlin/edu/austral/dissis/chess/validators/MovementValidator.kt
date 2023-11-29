package edu.austral.dissis.chess.validators

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class MovementValidator : Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        if (!board.getPositions().containsKey(movement.getFrom())) {
            return false
        }
        if (movement.getFrom().getX() == movement.getTo().getX() && movement.getFrom().getY() == movement.getTo().getY()) {
            return false
        }
        if (board.getPositions().containsKey(movement.getTo()) &&  board.getPiece(movement.getFrom())!!.getColor() == board.getPiece(movement.getTo())!!.getColor()){
            return false
        }
        if (board.getPiece(movement.getFrom())!!.getColor() != movement.getTurn()) {
            return false
        }
        return true
    }
}