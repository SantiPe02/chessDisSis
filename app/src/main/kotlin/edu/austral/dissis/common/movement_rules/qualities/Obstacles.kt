package edu.austral.dissis.common.movement_rules.qualities

import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class Obstacles: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        //implement a method that checks if there are obstacles in the way of any movementRule. It should return InvalidResult if there are any, and ValidResult if there are none.
        val from = movement.getFrom()
        val to = movement.getTo()
        val x = from.getRow()
        val y = from.getColumn()
        val x2 = to.getRow()
        val y2 = to.getColumn()
        if (x == x2) {
            if (y < y2) {
                for (i in y + 1 until y2) {
                    if (board.getPieceAt(x, i) != null) {
                        return InvalidResult("Invalid movement: there is an obstacle in the way")
                    }
                }
            } else {
                for (i in y - 1 downTo y2 + 1) {
                    if (board.getPieceAt(x, i) != null) {
                        return InvalidResult("Invalid movement: there is an obstacle in the way")
                    }
                }
            }
        } else if (y == y2) {
            if (x < x2) {
                for (i in x + 1 until x2) {
                    if (board.getPieceAt(i, y) != null) {
                        return InvalidResult("Invalid movement: there is an obstacle in the way")
                    }
                }
            } else {
                for (i in x - 1 downTo x2 + 1) {
                    if (board.getPieceAt(i, y) != null) {
                        return InvalidResult("Invalid movement: there is an obstacle in the way")
                    }
                }
            }
        } else if (x < x2) {
            if (y < y2) {
                var j = y + 1
                for (i in x + 1 until x2) {
                    if (board.getPieceAt(i, j) != null) {
                        return InvalidResult("Invalid movement: there is an obstacle in the way")
                    }
                    j++
                }
            } else {
                var j = y - 1
                for (i in x + 1 until x2) {
                    if (board.getPieceAt(i, j) != null) {
                        return InvalidResult("Invalid movement: there is an obstacle in the way")
                    }
                    j--
                }
            }
        } else if (y < y2) {
            var j = y + 1
            for (i in x - 1 downTo x2 + 1) {
                if (board.getPieceAt(i, j) != null) {
                    return InvalidResult("Invalid movement: there is an obstacle in the way")
                }
                j++
            }
        } else {
            var j = y - 1
            for (i in x - 1 downTo x2 + 1) {
                if (board.getPieceAt(i, j) != null) {
                    return InvalidResult("Invalid movement: there is an obstacle in the way")
                }
                j--
            }
        }
        return ValidResult()
    }
}