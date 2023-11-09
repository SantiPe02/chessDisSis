package edu.austral.dissis.chess.movement_rules

import edu.austral.dissis.chess.structure.Movement

class Straight {
    fun validate(movement: Movement): Boolean{
        return movement.getFrom().getX() == movement.getTo().getX() || movement.getFrom().getY() == movement.getTo().getY()
    }
}