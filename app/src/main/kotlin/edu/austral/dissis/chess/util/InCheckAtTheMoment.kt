package edu.austral.dissis.chess.util

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.structure.Board

fun inCheckAtTheMoment(board: Board, color: Color): Boolean {
    val kingPosition = findKingPosition(board, color)
    val enemyColor = if (color == Color.WHITE) Color.BLACK else Color.WHITE
    val enemyPossibleMovements = getAllPossiblePieceMovements(enemyColor, board)
    for (movement in enemyPossibleMovements){
        if (movement.getTo() == kingPosition) return true
    }
    return false
}