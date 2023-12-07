package edu.austral.dissis.checkers.turn_manager

import edu.austral.dissis.checkers.movers.HasEaten
import edu.austral.dissis.checkers.movers.Promotion
import edu.austral.dissis.checkers.movers.PromotionWhileEating
import edu.austral.dissis.checkers.util.boardAfterFirstEating
import edu.austral.dissis.checkers.util.boardAfterSecondEating
import edu.austral.dissis.checkers.util.boardWithTwoPossibleEatings
import edu.austral.dissis.checkers.validators.HasToEat
import edu.austral.dissis.checkers.winning_conditions.NoPiecesLeft
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

class CheckersTurnManagerTest {

    @Test
    fun checkersTurnManagerTest() {
        val boardBeforeEating = boardWithTwoPossibleEatings()
        val boardAfterEating = boardAfterFirstEating()
        val boardAfterSecondEating = boardAfterSecondEating()
        val movements: Array<Movement> = arrayOf()
        val turn = Color.WHITE
        val validators = arrayOf(InBoundsValidator(), TeamValidator(), MovementValidator(), HasToEat())
        val winningConditions = arrayOf(NoPiecesLeft(), AnotherWinningCondition())
        val turnManager = CheckersTurnManager()
        val movers = listOf(Promotion(), HasEaten(), PromotionWhileEating(), RegularMove())
        val game = Game(boardBeforeEating, movements, turn, validators, winningConditions, turnManager, movers)
        Assertions.assertTrue(turnManager.switchTurn(game, boardBeforeEating) == Color.WHITE)
        Assertions.assertTrue(turnManager.switchTurn(game, boardAfterEating) == Color.WHITE)
        Assertions.assertTrue(turnManager.switchTurn(game, boardAfterSecondEating) == Color.BLACK)
    }
}