package edu.austral.dissis.chess.validators

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class InBoundsValidator : Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        var valid = true
        if (movement.getFrom().getX() < 1 || movement.getFrom().getX() > board.getRow()) {
            valid = false
        }
        if (movement.getFrom().getY() < 1 || movement.getFrom().getY() > board.getCol()) {
            valid = false
        }
        return valid
    }
}