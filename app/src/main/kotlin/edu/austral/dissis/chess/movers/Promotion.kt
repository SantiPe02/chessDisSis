package edu.austral.dissis.chess.movers

import edu.austral.dissis.chess.factory.specific_rules.createClassicChessRules
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.mover.Mover
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Piece
import edu.austral.dissis.common.util.validatePromotion


class Promotion: Mover {
    override fun validate(movement: Movement, board: Board): Boolean {
        return validatePromotion(movement, board)
    }

    override fun move(movement: Movement, board: Board): Board {
        var i = 3
        val actualPiece = board.getPiece(movement.getFrom())
        val color = actualPiece!!.getColor()
        val newPiece = Piece("WQueen${i}", color, PieceType.QUEEN, createClassicChessRules(PieceType.QUEEN), true)
        i += 1
        return board.makeMove(movement.getFrom(), movement.getTo()).removePiece(movement.getTo()).addPiece(newPiece, movement.getTo())
    }
}