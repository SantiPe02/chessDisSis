package edu.austral.dissis.chess.factory.specific_rules

import edu.austral.dissis.chess.util.inCheckAtTheMoment
import edu.austral.dissis.chess.util.noPiecesBetweenCastling
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class RightCastlingCondition: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        if (board.getPiece(movement.getFrom())!!.getType() != PieceType.KING) return InvalidResult("The piece is not a king")

        if (movement.getTo().getRow() != movement.getFrom().getRow()) return InvalidResult("The king can't move in the Y axis")

        if (movement.getTo().getColumn() != movement.getFrom().getColumn() + 2 ) return InvalidResult("The king can't move two squares")

        if (!noPiecesBetweenCastling(board, movement)) return InvalidResult("There are pieces between the king and the rook")

        if (board.getPieceAt(movement.getFrom().getRow(), movement.getFrom().getColumn() + 3)!!.getHasMoved()) return InvalidResult("The rooks have already moved")

        if (inCheckAtTheMoment(board, movement.getTurn())) return InvalidResult("The king is in check")

        return ValidResult()
    }

    private fun movingTwoSquares(movement: Movement): Boolean {
        return movement.getTo().getColumn() == movement.getFrom().getColumn() + 2 || movement.getTo().getColumn() == movement.getFrom().getColumn() - 2
    }

    private fun rooksHaveNotMoved(board: Board, movement: Movement): Boolean {
        return board.getPieceAt(movement.getFrom().getRow(), movement.getFrom().getColumn() + 3)!!.getHasMoved() || board.getPieceAt(movement.getFrom().getRow(), movement.getFrom().getColumn() - 4)!!.getHasMoved()
    }
}