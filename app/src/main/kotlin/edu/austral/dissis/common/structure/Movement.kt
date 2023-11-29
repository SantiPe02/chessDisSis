package edu.austral.dissis.common.structure

import edu.austral.dissis.chess.enums.Color

data class Movement(
    private val from: Position,
    private val to: Position,
    private val turn: Color,
    private val board: Board
) {

    fun getFrom(): Position {
        val row = from.getX()
        val col = from.getY()
        for (key in board.getPositions().keys){
            if (key.getX() == row && key.getY() == col){
                return key
            }
        }
        return from
    }

    fun getTo(): Position {
        val row = to.getX()
        val col = to.getY()
        if (!board.getPositions().containsKey(to)) {
            for (key in board.getPositions().keys) {
                if (key.getX() == row && key.getY() == col) {
                    return key
                }
            }
        }
        return to
    }

    fun getTurn(): Color {
        return turn
    }

    fun getBoard(): Board {
        return board
    }
}