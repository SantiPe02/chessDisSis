package edu.austral.dissis.chess.turn_manager

import edu.austral.dissis.chess.factory.game.createNormalChessBoard
import edu.austral.dissis.chess.movers.LeftCastling
import edu.austral.dissis.chess.movers.Promotion
import edu.austral.dissis.chess.movers.RightCastling
import edu.austral.dissis.chess.validators.NotInCheck
import edu.austral.dissis.chess.winning_conditions.CheckMateValidator
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.mover.RegularMove
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.validators.InBoundsValidator
import edu.austral.dissis.common.validators.MovementValidator
import edu.austral.dissis.common.validators.TeamValidator
import edu.austral.dissis.common.winning_conditions.AnotherWinningCondition
import org.junit.Test
import org.junit.jupiter.api.Assertions

class ChessTurnManagerTest {

    @Test
    fun chessTurnManagerTest() {
        val board = createNormalChessBoard()
        val movements: Array<Movement> = arrayOf()
        val turn = Color.WHITE
        val validators = arrayOf(NotInCheck(), InBoundsValidator(), MovementValidator(), TeamValidator())
        val winningConditions = arrayOf(CheckMateValidator(), AnotherWinningCondition())
        val turnManager = ChessTurnManager()
        val movers = listOf(Promotion(), RightCastling(), LeftCastling(), RegularMove())
        val game = Game(board, movements, turn, validators, winningConditions, turnManager, movers)
        Assertions.assertTrue(turnManager.switchTurn(game, board) == Color.BLACK)
    }
}