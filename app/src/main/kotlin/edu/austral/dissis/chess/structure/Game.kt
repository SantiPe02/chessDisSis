package edu.austral.dissis.chess.structure

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.validators.*

class Game(
    private var actualBoard: Board = Board(arrayOf()),
    private var movements: Array<Board> = arrayOf(),
    private var eaten: Array<Piece> = arrayOf(),
    private var winner: Player = Player("name", Color.WHITE),
    private var turn: Player = Player("name", Color.WHITE),
    private var validators: Array<Validator> = arrayOf()
) {

    fun action(movement: Movement): Game {
        var canMove = false
        val newPositions = actualBoard.getPositions().clone()
        val newMovements = movements.clone()
        val newEaten = eaten.clone()

        for (validator in validators) {
            if (!validator.validate(movement, actualBoard)) {
                print("Invalid movement, broke validator")
                return this
            } else {
                canMove = true
            }
        }

        if (canMove) {
            if (CanEat.validate(movement)) {
                for (position in newPositions) {
                    if (position == movement.getFrom()) {
                        newPositions[newPositions.indexOf(position)] =
                            Position(movement.getFrom().getX(), movement.getFrom().getY(), null)
                    }
                    if (position == movement.getTo()) {
                        newPositions[newPositions.indexOf(position)] =
                            Position(movement.getTo().getX(), movement.getTo().getY(), movement.getFrom().getPiece())
                        newEaten.plus(movement.getTo().getPiece()!!)
                    }
                }
            } else {
                for (position in newPositions) {
                    if (position == movement.getFrom()) {
                        newPositions[newPositions.indexOf(position)] =
                            Position(movement.getFrom().getX(), movement.getFrom().getY(), null)
                    }
                    if (position == movement.getTo()) {
                        newPositions[newPositions.indexOf(position)] =
                            Position(movement.getTo().getX(), movement.getTo().getY(), movement.getFrom().getPiece())
                    }
                }
            }
            movement.getFrom().getPiece()!!.setHasMoved()
        } else {
            print("Invalid movement")
            return this
        }

        val newGame = Game(Board(newPositions), newMovements.plus(actualBoard), newEaten, winner, movement.getPlayerTurn(), validators)

        val ownCheck = CheckValidator().validate(newGame)

        val newGame2 = Game(Board(newPositions), newMovements.plus(actualBoard), newEaten, winner, switchTurn(), validators)

        val opponentCheck = CheckValidator().validate(newGame2)

        if (CheckMateValidator().validate(newGame2)) {
            println("End of the game, the winner is: " + turn.getColor())
            return Game()
        }

        if (opponentCheck){
            print("Check!")
        }

        if (ownCheck){
            print("Check!")
            return this
        }

        return newGame2
    }

    private fun switchTurn(): Player{
        var newTurn = turn
        newTurn = if (newTurn.getColor() == Color.WHITE){
            Player("name", Color.BLACK)
        } else{
            Player("name", Color.WHITE)
        }
        return newTurn
    }

    fun getActualBoard(): Board {
        return actualBoard
    }

    fun getMovements(): Array<Board> {
        return movements
    }

    fun getEaten(): Array<Piece> {
        return eaten
    }

    fun getWinner(): Player {
        return winner
    }

    fun getTurn(): Player {
        return turn
    }

    fun getValidators(): Array<Validator> {
        return validators
    }

    fun display(): String{
        return actualBoard.display()
    }

    fun initialState(): Game{
        val positions = arrayOfNulls<Position>(64)
        for (i in 0 until 64){
            positions[i] = Position(i % 8, i / 8, null)
        }
        positions[0] = Position(0, 0, Piece(Color.BLACK, PieceType.ROOK))
        positions[1] = Position(1, 0, Piece(Color.BLACK, PieceType.KNIGHT))
        positions[2] = Position(2, 0, Piece(Color.BLACK, PieceType.BISHOP))
        positions[3] = Position(3, 0, Piece(Color.BLACK, PieceType.QUEEN))
        positions[4] = Position(4, 0, Piece(Color.BLACK, PieceType.KING))
        positions[5] = Position(5, 0, Piece(Color.BLACK, PieceType.BISHOP))
        positions[6] = Position(6, 0, Piece(Color.BLACK, PieceType.KNIGHT))
        positions[7] = Position(7, 0, Piece(Color.BLACK, PieceType.ROOK))
        positions[8] = Position(0, 1, Piece(Color.BLACK, PieceType.PAWN))
        positions[9] = Position(1, 1, Piece(Color.BLACK, PieceType.PAWN))
        positions[10] = Position(2, 1, Piece(Color.BLACK, PieceType.PAWN))
        positions[11] = Position(3, 1, Piece(Color.BLACK, PieceType.PAWN))
        positions[12] = Position(4, 1, Piece(Color.BLACK, PieceType.PAWN))
        positions[13] = Position(5, 1, Piece(Color.BLACK, PieceType.PAWN))
        positions[14] = Position(6, 1, Piece(Color.BLACK, PieceType.PAWN))
        positions[15] = Position(7, 1, Piece(Color.BLACK, PieceType.PAWN))
        positions[48] = Position(0, 6, Piece(Color.WHITE, PieceType.PAWN))
        positions[49] = Position(1, 6, Piece(Color.WHITE, PieceType.PAWN))
        positions[50] = Position(2, 6, Piece(Color.WHITE, PieceType.PAWN))
        positions[51] = Position(3, 6, Piece(Color.WHITE, PieceType.PAWN))
        positions[52] = Position(4, 6, Piece(Color.WHITE, PieceType.PAWN))
        positions[53] = Position(5, 6, Piece(Color.WHITE, PieceType.PAWN))
        positions[54] = Position(6, 6, Piece(Color.WHITE, PieceType.PAWN))
        positions[55] = Position(7, 6, Piece(Color.WHITE, PieceType.PAWN))
        positions[56] = Position(0, 7, Piece(Color.WHITE, PieceType.ROOK))
        positions[57] = Position(1, 7, Piece(Color.WHITE, PieceType.KNIGHT))
        positions[58] = Position(2, 7, Piece(Color.WHITE, PieceType.BISHOP))
        positions[59] = Position(3, 7, Piece(Color.WHITE, PieceType.QUEEN))
        positions[60] = Position(4, 7, Piece(Color.WHITE, PieceType.KING))
        positions[61] = Position(5, 7, Piece(Color.WHITE, PieceType.BISHOP))
        positions[62] = Position(6, 7, Piece(Color.WHITE, PieceType.KNIGHT))
        positions[63] = Position(7, 7, Piece(Color.WHITE, PieceType.ROOK))
        var board = Board(positions as Array<Position>)
        var playerTurn = Player("name", Color.WHITE)
        var validatorList = arrayOf(InBoundsValidator(), TeamValidator(), MovementValidator(), InBetweenPieceValidator())
        return Game(board, movements, eaten, Player("name", Color.WHITE), playerTurn, validatorList)
    }
}
