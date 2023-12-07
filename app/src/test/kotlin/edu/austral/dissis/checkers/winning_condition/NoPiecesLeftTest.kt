package edu.austral.dissis.checkers.winning_condition

import edu.austral.dissis.checkers.movers.HasEaten
import edu.austral.dissis.checkers.movers.Promotion
import edu.austral.dissis.checkers.movers.PromotionWhileEating
import edu.austral.dissis.checkers.turn_manager.CheckersTurnManager
import edu.austral.dissis.checkers.util.kingTestingBoardWithPawn
import edu.austral.dissis.checkers.validators.HasToEat
import edu.austral.dissis.checkers.winning_conditions.NoPiecesLeft
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

class NoPiecesLeftTest {
    @Test
    fun noPiecesLeftTest() {
        val board = kingTestingBoardWithPawn()
        val movements: Array<Movement> = arrayOf()
        val turn = Color.WHITE
        val validators = arrayOf(InBoundsValidator(), TeamValidator(), MovementValidator(), HasToEat())
        val winningConditions = arrayOf(NoPiecesLeft(), AnotherWinningCondition())
        val turnManager = CheckersTurnManager()
        val movers = listOf(Promotion(), HasEaten(), PromotionWhileEating(), RegularMove())
        val game = Game(board, movements, turn, validators, winningConditions, turnManager, movers)
        val movement = Movement(Position(1, 1), Position(3, 3), Color.WHITE, board)
        Assertions.assertTrue(game.action(movement) is GameOverResult)
    }
}