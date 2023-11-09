package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.movement_rules.Diagonal
import edu.austral.dissis.chess.movement_rules.LForm
import edu.austral.dissis.chess.movement_rules.Straight
import edu.austral.dissis.chess.structure.Board
import edu.austral.dissis.chess.structure.Movement
import kotlin.math.abs

class MovementValidator : Validator {
    override fun validate(movement: Movement, board: Board): Boolean {
        var valid = false
        if (movement.getFrom() == movement.getTo()) return false

        when (movement.getFrom().getPiece()!!.getType()) {
            PieceType.ROOK -> {
                return Straight().validate(movement)
            }

            PieceType.BISHOP -> {
                return Diagonal().validate(movement)
            }

            PieceType.QUEEN -> {
                return Straight().validate(movement) || Diagonal().validate(movement)
            }

            PieceType.KING -> {
                if (abs(movement.getFrom().getX() - movement.getTo().getX()) <= 1 && abs(
                        movement.getFrom().getY() - movement.getTo().getY()
                    ) <= 1
                ) {
                    valid = true
                }
            }

            PieceType.KNIGHT -> {
                return LForm().validate(movement)
            }

            PieceType.PAWN -> {
                val from = movement.getFrom()
                val to = movement.getTo()

                val xDiff = abs(from.getX() - to.getX())
                val yDiff = from.getY() - to.getY()

                val isWhitePawn = movement.getFrom().getPiece()!!.getColor() == Color.WHITE

                if (CanEat.validate(movement)) {
                    if (!isWhitePawn && xDiff == 1 && yDiff == -1) {
                        valid = true
                    } else if (isWhitePawn && xDiff == 1 && yDiff == 1) {
                        valid = true
                    }
                } else {
                    if (isWhitePawn) {
                        if (xDiff == 0 && yDiff == 1) {
                            valid = true
                        }
                        if (xDiff == 0 && yDiff == 2 && !movement.getFrom().getPiece()!!.hasMoved()) {
                            valid = true
                        }
                    } else {
                        if (xDiff == 0 && yDiff == -1) {
                            valid = true
                        }
                        if (xDiff == 0 && yDiff == -2 && !movement.getFrom().getPiece()!!.hasMoved()) {
                            valid = true
                        }
                    }
                }
            }
        }
        return valid
    }
}