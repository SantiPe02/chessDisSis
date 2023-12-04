package edu.austral.dissis.chess.util

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position
import edu.austral.dissis.common.validators.MovementValidator

fun getAllPossiblePieceMovements(color: Color, board: Board): List<Movement> {
    val possibleMovements = mutableListOf<Movement>()
    for ((position, piece) in board.getPositions().filter { it.value.getColor() == color }) {
        for (i in 1..board.getRow()){
            for (j in 1..board.getCol()){
                val movement = Movement(position, Position(i, j), color, board)
                if (piece.getRules().validate(movement, board) is ValidResult && MovementValidator().validate(movement, board) is ValidResult) {
                    possibleMovements.add(movement)
                }
            }
        }
    }
    return possibleMovements
}