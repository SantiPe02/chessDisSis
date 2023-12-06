package edu.austral.dissis.checkers.movers

import edu.austral.dissis.checkers.factory.specific_rules.IsEating
import edu.austral.dissis.checkers.factory.specific_rules.createClassicCheckersRules
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.mover.Mover
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.util.validatePromotion

class Promotion: Mover {
    override fun validate(movement: Movement, board: Board): Boolean {
        return canPromoteButNotEat(movement, board)
    }

    override fun move(movement: Movement, board: Board): Board {
        val actualPiece = board.getPiece(movement.getFrom())
        val newPiece = actualPiece!!.copy(
            type = PieceType.KING,
            rules = createClassicCheckersRules(PieceType.KING)
        )
        return board.makeMove(movement.getFrom(), movement.getTo()).removePiece(movement.getTo()).addPiece(newPiece, movement.getTo())
    }

    private fun canPromoteButNotEat(movement: Movement, board: Board): Boolean {
        return validatePromotion(movement, board) && IsEating().validate(movement, board) !is ValidResult
    }
}