package edu.austral.dissis.client

import edu.austral.dissis.chess.gui.GameEventListener
import edu.austral.dissis.chess.gui.Move

class GameMoveListener(private val client: GameClient): GameEventListener {
    override fun handleMove(move: Move) {
        client.sendMove(move)
    }
}