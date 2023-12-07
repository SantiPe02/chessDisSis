package edu.austral.dissis.checkers.piece

import edu.austral.dissis.checkers.util.boardWithPawnAlone
import edu.austral.dissis.checkers.util.boardWithPawnCanEat
import edu.austral.dissis.checkers.util.kingTestingBoardAlone
import edu.austral.dissis.checkers.util.kingTestingBoardWithPawn
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position
import org.junit.Test
import org.junit.jupiter.api.Assertions

class CheckersPieceTest {

    @Test
    fun pawnTest() {
        // pawn regular movement
        val regularBoard = boardWithPawnAlone()
        val regularMovement = Movement(Position(1, 1), Position(2, 2), Color.WHITE, regularBoard)
        val piece = regularBoard.getPiece(regularMovement.getFrom())
        Assertions.assertTrue(piece!!.getRules().validate(regularMovement, regularBoard) is ValidResult)
        // pawn eating movement
        val eatingBoard = boardWithPawnCanEat()
        val eatingMovement = Movement(Position(3, 3), Position(5, 5), Color.WHITE, eatingBoard)
        val piece2 = eatingBoard.getPiece(eatingMovement.getFrom())
        Assertions.assertTrue(piece2!!.getRules().validate(eatingMovement, eatingBoard) is ValidResult)
    }

    @Test
    fun kingTest(){
        // king regular movement
        val regularBoard = kingTestingBoardAlone()
        val regularMovement = Movement(Position(1, 1), Position(2, 2), Color.WHITE, regularBoard)
        val piece = regularBoard.getPiece(regularMovement.getFrom())
        Assertions.assertTrue(piece!!.getRules().validate(regularMovement, regularBoard) is ValidResult)
        // eating movement
        val eatingBoard = kingTestingBoardWithPawn()
        val eatingMovement = Movement(Position(1, 1), Position(3, 3), Color.WHITE, eatingBoard)
        val piece2 = eatingBoard.getPiece(eatingMovement.getFrom())
        Assertions.assertTrue(piece2!!.getRules().validate(eatingMovement, eatingBoard) is ValidResult)
    }
}