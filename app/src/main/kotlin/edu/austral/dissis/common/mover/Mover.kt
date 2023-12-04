package edu.austral.dissis.common.mover

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

interface Mover {
    fun validate(movement: Movement, board: Board): Boolean
    fun move(movement: Movement, board: Board): Board
}