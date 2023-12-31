package edu.austral.dissis.checkers.factory.specific_rules

import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Piece

class IsEating: MovementRule {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        val from = movement.getFrom()
        val to = movement.getTo()

        val rowDirection = if (to.getRow() > from.getRow()) 1 else -1
        val columnDirection = if (to.getColumn() > from.getColumn()) 1 else -1

        val endingRow = from.getRow() + rowDirection
        val endingColumn = from.getColumn() + columnDirection

        val enemyPiece = board.getPieceAt(endingRow, endingColumn)
        val toPiece = board.getPiece(to)

        if (ableToEat(enemyPiece, movement, toPiece)){
            return ValidResult()
        }

        return InvalidResult("Invalid movement: no enemy around")
    }

    private fun ableToEat(enemyPiece: Piece?, movement: Movement, toPiece: Piece?): Boolean{
        return enemyPiece != null && enemyPiece.getColor() != movement.getTurn() && toPiece == null
    }
}