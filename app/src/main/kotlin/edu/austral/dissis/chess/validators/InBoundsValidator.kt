package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.structure.Board
import edu.austral.dissis.chess.structure.Movement

class InBoundsValidator : Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        var valid = false
        for (position in board.getPositions()) {
            if (movement.getTo() == position) {
                valid = true
            }
        }
        return valid
    }
}