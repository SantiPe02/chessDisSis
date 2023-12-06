package edu.austral.dissis.checkers.factory.game

import edu.austral.dissis.checkers.movers.HasEaten
import edu.austral.dissis.checkers.movers.Promotion
import edu.austral.dissis.checkers.movers.PromotionWhileEating
import edu.austral.dissis.checkers.turn_manager.CheckersTurnManager
import edu.austral.dissis.checkers.validators.HasToEat
import edu.austral.dissis.checkers.winning_conditions.NoPiecesLeft
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.mover.RegularMove
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.validators.InBoundsValidator
import edu.austral.dissis.common.validators.MovementValidator
import edu.austral.dissis.common.validators.TeamValidator
import edu.austral.dissis.common.winning_conditions.AnotherWinningCondition

fun createInitialCheckersGame(): Game {
    val board = createInitialCheckersBoard()
    val validators = arrayOf(InBoundsValidator(), TeamValidator(), MovementValidator(), HasToEat())
    val winningConditions = arrayOf(NoPiecesLeft(), AnotherWinningCondition())
    val turnManager = CheckersTurnManager()
    val movers = listOf(HasEaten(), Promotion(), PromotionWhileEating(), RegularMove())

    return Game(board, arrayOf(), Color.WHITE, validators, winningConditions, turnManager, movers)
}