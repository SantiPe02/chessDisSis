package edu.austral.dissis.chess.movement_rules

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import kotlin.math.abs

class LForm: MovementRule {
    override fun validate(movement: Movement, board: Board): Boolean{
        return (abs(movement.getFrom().getX() - movement.getTo().getX()) == 2 && abs(movement.getFrom().getY() - movement.getTo().getY()) == 1) || (abs(movement.getFrom().getX() - movement.getTo().getX()) == 1 && abs(movement.getFrom().getY() - movement.getTo().getY()) == 2)
    }
}