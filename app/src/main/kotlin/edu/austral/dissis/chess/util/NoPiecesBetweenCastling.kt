package edu.austral.dissis.chess.util

import edu.austral.dissis.common.movement_rules.qualities.Obstacles
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement

fun noPiecesBetweenCastling(board: Board, movement: Movement): Boolean {
    return Obstacles().validate(movement, board) is ValidResult
}