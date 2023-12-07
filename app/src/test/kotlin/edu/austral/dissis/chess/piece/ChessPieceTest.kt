package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.util.*
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position
import org.junit.Test
import org.junit.jupiter.api.Assertions

class ChessPieceTest {

    @Test
    fun pawnTest() {
        // pawn moves one place
        val boardWithPawnAlone = boardWithPawnAlone()
        val onePlaceMovement = Movement(Position(1, 1), Position(2, 1), Color.WHITE, boardWithPawnAlone)
        val piece = boardWithPawnAlone.getPiece(onePlaceMovement.getFrom())
        Assertions.assertTrue(piece!!.getRules().validate(onePlaceMovement, boardWithPawnAlone) is ValidResult)
        // pawn moves two places
        val boardWithPawnHasNotMoved = boardWithPawnHasNoMoves()
        val twoPlacesMovement = Movement(Position(1, 1), Position(3, 1), Color.WHITE, boardWithPawnHasNotMoved)
        val piece2 = boardWithPawnHasNotMoved.getPiece(twoPlacesMovement.getFrom())
        Assertions.assertTrue(piece2!!.getRules().validate(twoPlacesMovement, boardWithPawnHasNotMoved) is ValidResult)
        // pawn can eat
        val boardPawnCanEat = boardWithPawnPossibilityToEat()
        val eatingMovement = Movement(Position(1, 1), Position(2, 2), Color.WHITE, boardPawnCanEat)
        val piece3 = boardPawnCanEat.getPiece(eatingMovement.getFrom())
        Assertions.assertTrue(piece3!!.getRules().validate(eatingMovement, boardPawnCanEat) is ValidResult)
    }

    @Test
    fun rookTest() {
        // vertical movement
        val board = boardWithRookAlone()
        val verticalMovement = Movement(Position(1, 1), Position(7, 1), Color.WHITE, board)
        val piece = board.getPiece(verticalMovement.getFrom())
        Assertions.assertTrue(piece!!.getRules().validate(verticalMovement, board) is ValidResult)
        // horizontal movement
        val horizontalMovement = Movement(Position(1, 1), Position(1, 5), Color.WHITE, board)
        val piece2 = board.getPiece(horizontalMovement.getFrom())
        Assertions.assertTrue(piece2!!.getRules().validate(horizontalMovement, board) is ValidResult)
        // invalid movement
        val cannotMoveBoard = boardWithRookAndPieceBetween()
        val invalidMovement = Movement(Position(1, 1), Position(1, 5), Color.WHITE, cannotMoveBoard)
        val piece3 = cannotMoveBoard.getPiece(invalidMovement.getFrom())
        Assertions.assertTrue(piece3!!.getRules().validate(invalidMovement, cannotMoveBoard) !is ValidResult)
    }

    @Test
    fun knightTest() {
        // valid movement
        val board = boardWithKnightAlone()
        val movement = Movement(Position(1, 2), Position(3, 3), Color.WHITE, board)
        val piece = board.getPiece(movement.getFrom())
        Assertions.assertTrue(piece!!.getRules().validate(movement, board) is ValidResult)
        // invalid movement
        val movement2 = Movement(Position(1, 2), Position(3, 4), Color.WHITE, board)
        val piece2 = board.getPiece(movement2.getFrom())
        Assertions.assertTrue(piece2!!.getRules().validate(movement2, board) !is ValidResult)
    }

    @Test
    fun queenTest() {
        // vertical movement
        val board = boardWithQueenAlone()
        val verticalMovement = Movement(Position(1, 1), Position(7, 1), Color.WHITE, board)
        val piece = board.getPiece(verticalMovement.getFrom())
        Assertions.assertTrue(piece!!.getRules().validate(verticalMovement, board) is ValidResult)
        // horizontal movement
        val horizontalMovement = Movement(Position(1, 1), Position(1, 5), Color.WHITE, board)
        val piece2 = board.getPiece(horizontalMovement.getFrom())
        Assertions.assertTrue(piece2!!.getRules().validate(horizontalMovement, board) is ValidResult)
        // diagonal movement
        val diagonalMovement = Movement(Position(1, 1), Position(5, 5), Color.WHITE, board)
        val piece3 = board.getPiece(diagonalMovement.getFrom())
        Assertions.assertTrue(piece3!!.getRules().validate(diagonalMovement, board) is ValidResult)
    }

    @Test
    fun kingTest() {
        // vertical movement
        val board = kingInTheMiddleAlone()
        val verticalMovement = Movement(Position(4, 4), Position(5, 4), Color.WHITE, board)
        val piece = board.getPiece(verticalMovement.getFrom())
        Assertions.assertTrue(piece!!.getRules().validate(verticalMovement, board) is ValidResult)
        // horizontal movement
        val horizontalMovement = Movement(Position(4, 4), Position(4, 5), Color.WHITE, board)
        val piece2 = board.getPiece(horizontalMovement.getFrom())
        Assertions.assertTrue(piece2!!.getRules().validate(horizontalMovement, board) is ValidResult)
        // diagonal movement
        val diagonalMovement = Movement(Position(4, 4), Position(5, 5), Color.WHITE, board)
        val piece3 = board.getPiece(diagonalMovement.getFrom())
        Assertions.assertTrue(piece3!!.getRules().validate(diagonalMovement, board) is ValidResult)
    }
    @Test
    fun bishopTest() {
        // diagonal movement
        val board = boardWithBishopAlone()
        val diagonalMovement = Movement(Position(1, 1), Position(5, 5), Color.WHITE, board)
        val piece = board.getPiece(diagonalMovement.getFrom())
        Assertions.assertTrue(piece!!.getRules().validate(diagonalMovement, board) is ValidResult)
    }
}