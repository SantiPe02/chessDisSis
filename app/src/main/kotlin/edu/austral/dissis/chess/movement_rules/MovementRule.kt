package edu.austral.dissis.chess.movement_rules

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

interface MovementRule {
    fun validate(movement: Movement, board: Board): Boolean
}