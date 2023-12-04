package edu.austral.dissis.common.structure

import edu.austral.dissis.common.enums.Color

data class Movement(
    private val from: Position,
    private val to: Position,
    private val turn: Color,
    private val board: Board
) {

    fun getFrom(): Position {
        val row = from.getRow()
        val col = from.getColumn()
        for (key in board.getPositions().keys){
            if (key.getRow() == row && key.getColumn() == col){
                return key
            }
        }
        return from
    }

    fun getTo(): Position {
        val row = to.getRow()
        val col = to.getColumn()
        if (!board.getPositions().containsKey(to)) {
            for (key in board.getPositions().keys) {
                if (key.getRow() == row && key.getColumn() == col) {
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