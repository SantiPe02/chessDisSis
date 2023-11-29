package edu.austral.dissis.chess.validators

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

interface Validator {
    fun validate(movement: Movement, board: Board): Boolean
}