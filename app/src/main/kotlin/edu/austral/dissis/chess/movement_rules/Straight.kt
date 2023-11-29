package edu.austral.dissis.chess.movement_rules

import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class Straight: MovementRule {
    override fun validate(movement: Movement, board: Board): Boolean{
        return movement.getFrom().getX() == movement.getTo().getX() || movement.getFrom().getY() == movement.getTo().getY()
    }
}