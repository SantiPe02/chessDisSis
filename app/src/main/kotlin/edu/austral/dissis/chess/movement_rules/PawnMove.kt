package edu.austral.dissis.chess.movement_rules

import edu.austral.dissis.chess.validators.InBetweenPieceValidator
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import kotlin.math.abs

class PawnMove : MovementRule {
    override fun validate(movement: Movement, board: Board): Boolean {
        return true
    }
}