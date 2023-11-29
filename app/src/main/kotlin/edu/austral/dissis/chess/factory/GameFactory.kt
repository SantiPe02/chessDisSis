package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.chess.validators.InBetweenPieceValidator
import edu.austral.dissis.chess.validators.InBoundsValidator
import edu.austral.dissis.chess.validators.MovementValidator
import edu.austral.dissis.chess.validators.TeamValidator
import edu.austral.dissis.chess.winning_conditions.AnotherWinningCondition
import edu.austral.dissis.chess.winning_conditions.CheckMateValidator

fun createInitialGame(): Game {
    val board = createNormalBoard()
    val validators = arrayOf(TeamValidator(), InBoundsValidator(), MovementValidator(), InBetweenPieceValidator())
    val turn = Color.WHITE
    val winningConditions = arrayOf(CheckMateValidator(), AnotherWinningCondition())

    return Game(board, arrayOf(board), turn, validators, winningConditions)
}