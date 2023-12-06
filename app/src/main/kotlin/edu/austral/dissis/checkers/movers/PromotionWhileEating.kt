package edu.austral.dissis.checkers.movers

import edu.austral.dissis.checkers.factory.specific_rules.IsEating
import edu.austral.dissis.checkers.factory.specific_rules.createClassicCheckersRules
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.mover.Mover
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.util.validatePromotion

class PromotionWhileEating: Mover {
    override fun validate(movement: Movement, board: Board): Boolean {
        return isEatingAndPromoting(movement, board)
    }

    override fun move(movement: Movement, board: Board): Board {
        val actualPiece = board.getPiece(movement.getFrom())
        val newPiece = actualPiece!!.copy(
            type = PieceType.KING,
            rules = createClassicCheckersRules(PieceType.KING)
        )

        val from = movement.getFrom()
        val to = movement.getTo()

        val rowDirection = if (to.getRow() > from.getRow()) 1 else -1
        val columnDirection = if (to.getColumn() > from.getColumn()) 1 else -1

        val endingRow = from.getRow() + rowDirection
        val endingColumn = from.getColumn() + columnDirection

        val piece = board.getPieceAt(endingRow, endingColumn)!!
        val position = board.getPositions().keys.find { board.getPiece(it) == piece }!!

        return board.makeMove(from, to).removePiece(position).removePiece(movement.getTo()).addPiece(newPiece, movement.getTo())
    }

    private fun isEatingAndPromoting(movement: Movement, board: Board): Boolean {
        return IsEating().validate(movement, board) is ValidResult && validatePromotion(movement, board)
    }
}