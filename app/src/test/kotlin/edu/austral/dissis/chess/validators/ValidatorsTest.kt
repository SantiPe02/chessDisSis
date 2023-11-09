package edu.austral.dissis.chess.validators

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.structure.*
import edu.austral.dissis.chess.validators.MovementValidator
import org.testng.annotations.Test

class ValidatorsTest {
    var player1 = Player("santi", Color.BLACK)
    var player2 = Player("nico", Color.WHITE)
    var piece1 = Piece(Color.BLACK, PieceType.BISHOP)
    var piece2 = Piece(Color.WHITE, PieceType.ROOK)
    var piece3 = Piece(Color.WHITE, PieceType.PAWN)
    var piece4 = Piece(Color.BLACK, PieceType.QUEEN)
    var piece5 = Piece(Color.BLACK, PieceType.KING)
    var piece6 = Piece(Color.BLACK, PieceType.KNIGHT)
    var position1 = Position(1, 1, piece1)
    var position2 = Position(6, 4, piece2)
    var position3 = Position(4, 4, piece4)
    var position4 = Position(5, 5, piece3)
    var position5 = Position(6, 6, piece5)
    var position6 = Position(2, 2, piece6)
    var position7 = Position(3, 3, null)
    val positions = arrayOf(position1, position2, position3, position4, position5, position6, position7)
    var board = Board(positions)
    var movement1 = Movement(player1, position1, position4)

    @Test
    fun checkMateValidatorTest(){
        //TODO
    }

    @Test
    fun checkValidatorTest(){
        //TODO
    }

    @Test
    fun inBetweenPieceValidatorTest(){
        //TODO
    }

    @Test
    fun inBoundsValidatorTest(){
        //TODO
    }

    @Test
    fun movementValidatorTest(){
        var movementValidator = MovementValidator()
        assert(movementValidator.validate(movement1, board))
    }

    @Test
    fun teamValidatorTest(){
        //TODO
    }
}