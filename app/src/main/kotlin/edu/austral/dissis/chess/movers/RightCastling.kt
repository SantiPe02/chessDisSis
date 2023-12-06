package edu.austral.dissis.chess.movers

import edu.austral.dissis.chess.factory.specific_rules.RightCastlingCondition
import edu.austral.dissis.chess.util.noPiecesBetweenCastling
import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.mover.Mover
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position

class RightCastling: Mover {
    private val rightCastling: MovementRule = RightCastlingCondition()
    override fun validate(movement: Movement, board: Board): Boolean {
        return rightCastling.validate(movement, board) is ValidResult && noPiecesBetweenCastling(board, movement)
    }

    override fun move(movement: Movement, board: Board): Board {
        val actualKingPosition = movement.getFrom()

        val newKingPosition = movement.getTo()
        val actualRookPosition = board.getPositions().keys.find { it.getRow() == movement.getFrom().getRow() && it.getColumn() == movement.getFrom().getColumn() + 3 }
        val newRookPosition = Position(movement.getFrom().getRow(), movement.getFrom().getColumn() + 1)

        return board.makeMove(actualKingPosition, newKingPosition).makeMove(actualRookPosition!!, newRookPosition)
    }
}