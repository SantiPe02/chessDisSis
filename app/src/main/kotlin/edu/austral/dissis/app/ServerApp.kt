package edu.austral.dissis.app

import edu.austral.dissis.chess.factory.game.createInitialChessGame
import edu.austral.dissis.server.GameServer

fun main() {
    GameServer(createInitialChessGame())
}