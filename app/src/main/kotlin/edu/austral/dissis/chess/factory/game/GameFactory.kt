package edu.austral.dissis.chess.factory.game

import edu.austral.dissis.chess.movers.LeftCastling
import edu.austral.dissis.chess.movers.Promotion
import edu.austral.dissis.chess.movers.RightCastling
import edu.austral.dissis.chess.turn_manager.ChessTurnManager
import edu.austral.dissis.chess.validators.NotInCheck
import edu.austral.dissis.chess.winning_conditions.CheckMateValidator
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.mover.RegularMove
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.validators.InBoundsValidator
import edu.austral.dissis.common.validators.MovementValidator
import edu.austral.dissis.common.validators.TeamValidator
import edu.austral.dissis.common.winning_conditions.AnotherWinningCondition

fun createInitialChessGame(): Game {
    val board = createNormalChessBoard()
    val validators = arrayOf(TeamValidator(), InBoundsValidator(), MovementValidator(), NotInCheck())
    val turn = Color.WHITE
    val winningConditions = arrayOf(CheckMateValidator(), AnotherWinningCondition())
    val turnManager = ChessTurnManager()
    val movers = listOf(RightCastling(), LeftCastling(), Promotion(), RegularMove())

    return Game(board, arrayOf(), turn, validators, winningConditions, turnManager, movers)
}