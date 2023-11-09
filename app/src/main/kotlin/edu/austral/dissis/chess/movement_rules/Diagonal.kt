package edu.austral.dissis.chess.movement_rules

import edu.austral.dissis.chess.structure.Movement
import kotlin.math.abs

class Diagonal {
    fun validate(movement: Movement): Boolean{
        return abs(movement.getFrom().getX() - movement.getTo().getX()) == abs(movement.getFrom().getY() - movement.getTo().getY())
    }
}