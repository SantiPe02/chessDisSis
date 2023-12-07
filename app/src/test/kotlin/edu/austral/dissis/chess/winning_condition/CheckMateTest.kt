package edu.austral.dissis.chess.winning_condition

import edu.austral.dissis.chess.movers.LeftCastling
import edu.austral.dissis.chess.movers.Promotion
import edu.austral.dissis.chess.movers.RightCastling
import edu.austral.dissis.chess.turn_manager.ChessTurnManager
import edu.austral.dissis.chess.util.kingIsInCheckmate
import edu.austral.dissis.chess.validators.NotInCheck
import edu.austral.dissis.chess.winning_conditions.CheckMateValidator
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.mover.RegularMove
import edu.austral.dissis.common.results.move_results.GameOverResult
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position
import edu.austral.dissis.common.validators.InBoundsValidator
import edu.austral.dissis.common.validators.MovementValidator
import edu.austral.dissis.common.validators.TeamValidator
import edu.austral.dissis.common.winning_conditions.AnotherWinningCondition
import org.junit.Test
import org.junit.jupiter.api.Assertions

class CheckMateTest {

    @Test
    fun checkMateTest() {
        val board = kingIsInCheckmate()
        val movements: Array<Movement> = arrayOf()
        val turn = Color.BLACK
        val validators = arrayOf(NotInCheck(), InBoundsValidator(), MovementValidator(), TeamValidator())
        val winningConditions = arrayOf(CheckMateValidator(), AnotherWinningCondition())
        val turnManager = ChessTurnManager()
        val movers = listOf(Promotion(), RightCastling(), LeftCastling(), RegularMove())
        val game = Game(board, movements, turn, validators, winningConditions, turnManager, movers)
        val movement = Movement(Position(3, 2), Position(2, 2), Color.BLACK, board)
        Assertions.assertTrue(game.action(movement) is GameOverResult)
    }
}