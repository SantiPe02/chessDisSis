package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.movement_rules.Straight
import edu.austral.dissis.chess.structure.Board
import edu.austral.dissis.chess.structure.Movement

class InBetweenPieceValidator : Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        if (CanJump().validate(movement)) {
            return true
        }

        val from = movement.getFrom()
        val to = movement.getTo()

        val xDiff = to.getX() - from.getX()
        val yDiff = to.getY() - from.getY()
        val xIncrement = if (xDiff > 0) 1 else if (xDiff < 0) -1 else 0
        val yIncrement = if (yDiff > 0) 1 else if (yDiff < 0) -1 else 0

        var currentX = from.getX() + xIncrement
        var currentY = from.getY() + yIncrement

        while (currentX != to.getX() || currentY != to.getY()) {
            val currentPosition = board.getPositions()[currentY * 8 + currentX]

            if (currentPosition.getPiece() != null) {
                return false
            }

            currentX += xIncrement
            currentY += yIncrement
        }

        return true
    }
}