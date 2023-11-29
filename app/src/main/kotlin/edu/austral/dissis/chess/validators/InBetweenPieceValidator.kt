package edu.austral.dissis.chess.validators

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class InBetweenPieceValidator : Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        if (CanJump().validate(movement, board)) {
            return true
        }
        if (movement.getFrom().getX() == movement.getTo().getX()) {
            if (movement.getFrom().getY() < movement.getTo().getY()) {
                for (i in movement.getFrom().getY() + 1 until movement.getTo().getY()) {
                    if (board.getPieceAt(movement.getFrom().getX(), i) != null) {
                        return false
                    }
                }
            } else {
                for (i in movement.getFrom().getY() - 1 downTo movement.getTo().getY() + 1) {
                    if (board.getPieceAt(movement.getFrom().getX(), i) != null) {
                        return false
                    }
                }
            }
        } else {
            if (movement.getFrom().getX() < movement.getTo().getX()) {
                for (i in movement.getFrom().getX() + 1 until movement.getTo().getX()) {
                    if (board.getPieceAt(i, movement.getFrom().getY()) != null) {
                        return false
                    }
                }
            } else {
                for (i in movement.getFrom().getX() - 1 downTo movement.getTo().getX() + 1) {
                    if (board.getPieceAt(i, movement.getFrom().getY()) != null) {
                        return false
                    }
                }
            }
        }
    return true
    }
}