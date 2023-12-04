package edu.austral.dissis.checkers.movers

import edu.austral.dissis.checkers.factory.specific_rules.IsEating
import edu.austral.dissis.common.mover.Mover
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

class HasEaten: Mover {
    override fun validate(movement: Movement, board: Board): Boolean {
        return IsEating().validate(movement, board) is ValidResult
    }

    override fun move(movement: Movement, board: Board): Board {
        val from = movement.getFrom()
        val to = movement.getTo()

        val rowDirection = if (to.getRow() > from.getRow()) 1 else -1
        val columnDirection = if (to.getColumn() > from.getColumn()) 1 else -1

        val endingRow = from.getRow() + rowDirection
        val endingColumn = from.getColumn() + columnDirection

        val piece = board.getPieceAt(endingRow, endingColumn)!!
        val position = board.getPositions().keys.find { board.getPiece(it) == piece }!!

        return board.makeMove(from, to).removePiece(position)
    }
}