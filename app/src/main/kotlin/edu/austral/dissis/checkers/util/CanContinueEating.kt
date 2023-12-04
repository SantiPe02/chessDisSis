package edu.austral.dissis.checkers.util

import edu.austral.dissis.checkers.factory.specific_rules.IsEating
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Board

fun canContinueEating(board: Board, color: Color): Boolean {
    for ((_, piece) in board.getPositions()) {
        if (piece.getColor() != color) continue
        for (movement in piece.getPossibleMovements(board)){
            if (IsEating().validate(movement, board) is ValidResult) return true
        }
    }
    return false
}