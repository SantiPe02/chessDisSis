package edu.austral.dissis.chess.structure

class Movement(
    private val playerTurn: Player,
    private val from: Position,
    private val to: Position
) {

    fun getPlayerTurn(): Player {
        return playerTurn
    }

    fun getFrom(): Position {
        return from
    }

    fun getTo(): Position {
        return to
    }
}