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
        if (noRookToTheLeft(movement, board)) return InvalidResult("There is no rook to the left of the king")

        if (pieceNotKing(movement, board)) return InvalidResult("The piece is not a king")

        if (notHorizontalMovement(movement)) return InvalidResult("The king can't move in the Y axis")

        if (notMovingTwoSquaresToTheLeft(movement)) return InvalidResult("The king can only move two squares")

        if (rookAlreadyMoved(movement, board)) return InvalidResult("The rook has already moved")

        return ValidResult()
    }

    private fun noRookToTheLeft(movement: Movement, board: Board): Boolean {
        return board.getPieceAt(movement.getFrom().getRow(), movement.getFrom().getColumn() - 4) == null
    }

    private fun pieceNotKing(movement: Movement, board: Board): Boolean {
        return board.getPiece(movement.getFrom())!!.getType() != PieceType.KING
    }

    private fun notHorizontalMovement(movement: Movement): Boolean {
        return movement.getTo().getRow() != movement.getFrom().getRow()
    }

    private fun notMovingTwoSquaresToTheLeft(movement: Movement): Boolean {
        return movement.getTo().getColumn() != movement.getFrom().getColumn() - 2
    }

    private fun rookAlreadyMoved(movement: Movement, board: Board): Boolean {
        return board.getPieceAt(movement.getFrom().getRow(), movement.getFrom().getColumn() - 4)!!.getHasMoved()
    }
}