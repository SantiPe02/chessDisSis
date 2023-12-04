package edu.austral.dissis.chess.util

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position
import edu.austral.dissis.common.validators.InBoundsValidator
import edu.austral.dissis.common.validators.MovementValidator

fun findKingPosition(board: Board, color: Color): Position {
    for ((position, piece) in board.getPositions()){
        if (piece.getColor() == color && piece.getType() == PieceType.KING) return position
    }
    return Position(-1, -1)
}

fun getPossibleKingMoves(board: Board, color: Color): List<Movement> {
    val kingPosition = findKingPosition(board, color)
    val possibleMoves = mutableListOf<Movement>()
    val king = board.getPiece(kingPosition)!!
    for (i in -1..1) {
        for (j in -1..1) {
            if (i == 0 && j == 0) continue
            val movement = Movement(kingPosition, Position(kingPosition.getRow() + i, kingPosition.getColumn() + j), color, board)
            if (InBoundsValidator().validate(movement, board) is ValidResult && MovementValidator().validate(movement, board) is ValidResult && king.getRules().validate(movement, board) is ValidResult) {
                possibleMoves.add(movement)
            }
        }
    }
    return possibleMoves
}