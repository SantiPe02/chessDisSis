package edu.austral.dissis.chess.validators

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class TeamValidator : Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        return board.getPiece(movement.getFrom())!!.getColor() == movement.getTurn()
    }
}