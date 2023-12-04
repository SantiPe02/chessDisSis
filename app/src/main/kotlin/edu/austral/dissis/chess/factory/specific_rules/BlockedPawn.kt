package edu.austral.dissis.chess.factory.specific_rules

import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement


class BlockedPawn: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        val from = movement.getFrom()
        val to = movement.getTo()
        if (from.getColumn() == to.getColumn() && board.getPiece(to) != null) {
            return InvalidResult("Invalid movement: blocked pawn")
        }
        return ValidResult()
    }
}