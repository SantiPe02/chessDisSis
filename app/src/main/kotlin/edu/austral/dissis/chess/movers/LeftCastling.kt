package edu.austral.dissis.chess.movers

import edu.austral.dissis.chess.util.noPiecesBetweenCastling
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.mover.Mover
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position

class LeftCastling: Mover {
    override fun validate(movement: Movement, board: Board): Boolean {
        if (board.getPiece(movement.getFrom())!!.getType() != PieceType.KING) return false

        if (movement.getTo().getRow() != movement.getFrom().getRow()) return false

        if (movement.getTo().getColumn() != movement.getFrom().getColumn() - 2 ) return false

        if (!noPiecesBetweenCastling(board, movement)) return false

        if (board.getPieceAt(movement.getFrom().getRow(), movement.getFrom().getColumn() - 4)!!.getHasMoved()) return false

        return true
    }

    override fun move(movement: Movement, board: Board): Board {
        val actualKingPosition = movement.getFrom()

        val newKingPosition = movement.getTo()
        val actualRookPosition = board.getPositions().keys.find { it.getRow() == movement.getFrom().getRow() && it.getColumn() == movement.getFrom().getColumn() - 4 }
        val newRookPosition = Position(movement.getFrom().getRow(), movement.getFrom().getColumn() - 1)

        return board.makeMove(actualKingPosition, newKingPosition).makeMove(actualRookPosition!!, newRookPosition)
    }
}