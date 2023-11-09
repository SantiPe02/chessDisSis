package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.structure.Board
import edu.austral.dissis.chess.structure.Movement

class TeamValidator : Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        return movement.getPlayerTurn().getColor() == movement.getFrom().getPiece()!!.getColor()
    }
}