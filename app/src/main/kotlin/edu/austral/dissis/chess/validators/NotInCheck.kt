package edu.austral.dissis.chess.validators

import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.chess.util.findKingPosition
import edu.austral.dissis.common.results.validation_results.InvalidResult
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.results.validation_results.ValidationResult
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.validators.Validator

class NotInCheck: Validator {
    override fun validate(movement: Movement, board: Board): ValidationResult {
        val newBoard = board.makeMove(movement.getFrom(), movement.getTo())
        val newKingPosition = findKingPosition(newBoard, movement.getTurn())
        for ((position, piece) in newBoard.getPositions().filter { it.value.getColor() != movement.getTurn() }) {
            val opponentMovement = Movement(position, newKingPosition, switchTurn(movement.getTurn()), newBoard)
            if (piece.getRules().validate(opponentMovement, newBoard) is ValidResult){
                return InvalidResult("Invalid movement: king is in check")
            }
        }
        return ValidResult()
    }

    private fun switchTurn(color: Color): Color {
        return if (color == Color.WHITE) Color.BLACK else Color.WHITE
    }
}