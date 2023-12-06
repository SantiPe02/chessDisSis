package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.factory.game.createNormalChessBoard
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position
import org.testng.annotations.Test

class PieceTest {
    private val board = createNormalChessBoard()

    @Test
    fun pawnTest() {
        val movement = Movement(Position(2, 1), Position(4, 1), Color.WHITE, board)
        val piece = board.getPiece(movement.getFrom())
        assert(piece!!.getRules().validate(movement, board) is ValidResult)
        val newBoard = board.makeMove(movement.getFrom(), movement.getTo())
        val movement2 = Movement(Position(7, 2), Position(5, 2), Color.BLACK, newBoard)
        val piece2 = board.getPiece(movement2.getFrom())
        assert(piece2!!.getRules().validate(movement2, newBoard) is ValidResult)
        val newBoard2 = newBoard.makeMove(movement2.getFrom(), movement2.getTo())
        val movement3 = Movement(Position(4, 1), Position(5, 2), Color.WHITE, newBoard2)
        val piece3 = board.getPiece(movement3.getFrom())
        assert(piece3!!.getRules().validate(movement3, newBoard2) is ValidResult)
    }

    @Test
    fun rookTest() {

    }

    @Test
    fun knightTest() {

    }

    @Test
    fun queenTest() {

    }

    @Test
    fun kingTest() {

    }
    @Test
    fun bishopTest() {

    }
}