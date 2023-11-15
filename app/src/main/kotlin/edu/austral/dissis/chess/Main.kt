package edu.austral.dissis.chess

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.structure.*

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val game = Game().initialState()
            println(game.display())
//            val movement = Movement(game.getTurn(), game.getActualBoard().getPositions()[48], game.getActualBoard().getPositions()[32])
//            val newGame = game.action(movement)
//            println(newGame.display())
//            val movement2 = Movement(newGame.getTurn(), newGame.getActualBoard().getPositions()[9], newGame.getActualBoard().getPositions()[25])
//            val newGame2 = newGame.action(movement2)
//            println(newGame2.display())
//            val movement3 = Movement(newGame2.getTurn(), newGame2.getActualBoard().getPositions()[56], newGame2.getActualBoard().getPositions()[40])
//            val newGame3 = newGame2.action(movement3)
//            println(newGame3.display())
//            val movement4 = Movement(newGame3.getTurn(), newGame3.getActualBoard().getPositions()[10], newGame3.getActualBoard().getPositions()[26])
//            val newGame4 = newGame3.action(movement4)
//            println(newGame4.display())
//            val movement5 = Movement(newGame4.getTurn(), newGame4.getActualBoard().getPositions()[40], newGame4.getActualBoard().getPositions()[41])
//            val newGame5 = newGame4.action(movement5)
//            println(newGame5.display())
//            val movement6 = Movement(newGame5.getTurn(), newGame5.getActualBoard().getPositions()[15], newGame5.getActualBoard().getPositions()[23])
//            val newGame6 = newGame5.action(movement6)
//            println(newGame6.display())
//            val movement7 = Movement(newGame6.getTurn(), newGame6.getActualBoard().getPositions()[32], newGame6.getActualBoard().getPositions()[25])
//            val newGame7 = newGame6.action(movement7)
//            println(newGame7.display())
//            val movement8 = Movement(newGame7.getTurn(), newGame7.getActualBoard().getPositions()[8], newGame7.getActualBoard().getPositions()[16])
//            val newGame8 = newGame7.action(movement8)
//            println(newGame8.display())
//            val movement9 = Movement(newGame8.getTurn(), newGame8.getActualBoard().getPositions()[25], newGame8.getActualBoard().getPositions()[16])
//            val newGame9 = newGame8.action(movement9)
//            println(newGame9.display())
//            val movement10 = Movement(newGame9.getTurn(), newGame9.getActualBoard().getPositions()[1], newGame9.getActualBoard().getPositions()[16])
//            val newGame10 = newGame9.action(movement10)
//            println(newGame10.display())


            val movement = Movement(game.getTurn(), game.getActualBoard().getPositions()[54], game.getActualBoard().getPositions()[38])
            val newGame1 = game.action(movement)
            println(newGame1.display())
            val movement2 = Movement(newGame1.getTurn(), newGame1.getActualBoard().getPositions()[12], newGame1.getActualBoard().getPositions()[20])
            val newGame2 = newGame1.action(movement2)
            println(newGame2.display())
            val movement3 = Movement(newGame2.getTurn(), newGame2.getActualBoard().getPositions()[53], newGame2.getActualBoard().getPositions()[45])
            val newGame3 = newGame2.action(movement3)
            println(newGame3.display())
            val movement4 = Movement(newGame3.getTurn(), newGame3.getActualBoard().getPositions()[3], newGame3.getActualBoard().getPositions()[39])
            val newGame4 = newGame3.action(movement4)
//            println(newGame4.display())
//            val movement5 = Movement(newGame4.getTurn(), newGame4.getActualBoard().getPositions()[60], newGame4.getActualBoard().getPositions()[53])
//            val newGame5 = newGame4.action(movement5)
//            println(newGame5.display())
//            val movement6 = Movement(newGame5.getTurn(), newGame5.getActualBoard().getPositions()[8], newGame5.getActualBoard().getPositions()[16])
//            val newGame6 = newGame5.action(movement6)
//            println(newGame6.display())
//            val movement7 = Movement(newGame5.getTurn(), newGame5.getActualBoard().getPositions()[60], newGame5.getActualBoard().getPositions()[52])
//            val newGame7 = newGame5.action(movement7)
//            println(newGame7.display())
        }
    }
}