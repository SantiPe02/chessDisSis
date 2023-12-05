package edu.austral.dissis.chess.factory.specific_rules

import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class LeftCastlingCondition: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (board.getPiece(movement.getFrom())!!.getType() != PieceType.KING) return InvalidResult("The piece is not a king")

        if (movement.getTo().getRow() != movement.getFrom().getRow()) return InvalidResult("The king can't move in the Y axis")

        if (movement.getTo().getColumn() != movement.getFrom().getColumn() - 2 ) return InvalidResult("The king can't move two squares")

        if (board.getPieceAt(movement.getFrom().getRow(), movement.getFrom().getColumn() - 4)!!.getHasMoved()) return InvalidResult("The rook has already moved")

        return ValidResult()
    }
}