package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.structure.Board
import edu.austral.dissis.chess.structure.Movement

interface Validator {
    fun validate(movement: Movement, board: Board): Boolean
}