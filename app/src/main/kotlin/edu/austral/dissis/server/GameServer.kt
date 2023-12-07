package edu.austral.dissis.server


import com.fasterxml.jackson.core.type.TypeReference
import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.common.adapter.pieceAdapter
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.results.move_results.CanMoveResult
import edu.austral.dissis.common.results.move_results.GameOverResult
import edu.austral.dissis.common.results.move_results.InvalidMovement
import edu.austral.dissis.common.structure.Game
import edu.austral.dissis.common.structure.Movement
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.Server
import edu.austral.ingsis.clientserver.ServerBuilder
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder

class GameServer(private var game: Game,
                 private val serverBuilder: ServerBuilder = NettyServerBuilder.createDefault()
){

    private val server: Server
    init {
        server = buildServer()
        server.start()
    }

    fun handleMove(move: Move){
        val from = edu.austral.dissis.common.structure.Position(move.from.row, move.from.column)
        val to = edu.austral.dissis.common.structure.Position(move.to.row, move.to.column)
        val movement = Movement(from, to, game.getTurn(), game.getActualBoard())

        when (val result = game.action(movement)){
            is CanMoveResult -> {
                server.broadcast(Message("new-game-state",handleNewGameState(result)))
            }
            is InvalidMovement -> {
                server.broadcast(Message("invalid-move",InvalidMove(result.getReason())))
            }
            is GameOverResult -> {
                server.broadcast(Message("game-over",GameOver(handleColor(result.getWinner()))))
            }
        }
    }

    fun stop(){
        server.stop()
    }

    fun handleInitialConnection(){
        val boardSize = BoardSize(game.getActualBoard().getCol(),game.getActualBoard().getRow())
        val pieces = pieceAdapter(game)
        val color = when (game.getTurn()){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
        server.broadcast(Message("initial-state",InitialState(boardSize,pieces,color)))
    }

    private fun handleNewGameState(result: CanMoveResult): MoveResult{
        game = result.game
        val pieces = pieceAdapter(game)
        val color = when (game.getTurn()){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
        return NewGameState(pieces,color)
    }

    private fun buildServer(): Server{
        return serverBuilder
            .withPort(8080)
            .addMessageListener("initial-state",
                object : TypeReference<Message<Unit>>() {},
                InitListener(this))
            .addMessageListener(
                "move",
                object : TypeReference<Message<Move>> () {},
                MoveListener(this)
            )
            .build()
    }

    private fun handleColor(color: Color): PlayerColor {
        return when (color){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
    }
}