package edu.austral.dissis.common.mover

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class RegularMove: Mover {
    override fun validate(movement: Movement, board: Board): Boolean {
        return true
    }

    override fun move(movement: Movement, board: Board): Board {
        return board.makeMove(movement.getFrom(), movement.getTo())
    }
}