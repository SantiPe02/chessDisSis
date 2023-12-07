package edu.austral.dissis.checkers

import edu.austral.dissis.common.adapter.Adapter
import edu.austral.dissis.checkers.factory.game.createInitialCheckersGame
import edu.austral.dissis.chess.gui.CachedImageResolver
import edu.austral.dissis.chess.gui.DefaultImageResolver
import edu.austral.dissis.chess.gui.createGameViewFrom
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.stage.Stage


fun main() {
    launch(CheckersGameApplication::class.java)
}

class CheckersGameApplication : Application() {
    private val gameEngine = Adapter(createInitialCheckersGame())
    private val imageResolver = CachedImageResolver(DefaultImageResolver())

    companion object {
        const val GameTitle = "Checkers"
    }

    override fun start(primaryStage: Stage) {
        primaryStage.title = GameTitle

        val root = createGameViewFrom(gameEngine, imageResolver)
        primaryStage.scene = Scene(root)

        primaryStage.show()
    }
}