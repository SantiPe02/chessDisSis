package edu.austral.dissis.chess.factory.game

import edu.austral.dissis.chess.factory.specific_rules.createClassicChessRules
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Piece
import edu.austral.dissis.common.structure.Position

fun createNormalChessBoard(): Board {
    val map: MutableMap<Position, Piece> = mutableMapOf()

    for (i in 1..8){
        map[Position(2, i)] = Piece("Wpawn${i}", Color.WHITE, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), false)
        map[Position(7, i)] = Piece("Bpawn${i}", Color.BLACK, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), false)
    }

    map[Position(1, 1)] = Piece("Wrook1", Color.WHITE, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), false)
    map[Position(1, 8)] = Piece("Wrook2", Color.WHITE, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), false)
    map[Position(8, 1)] = Piece("Brook1", Color.BLACK, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), false)
    map[Position(8, 8)] = Piece("Brook2", Color.BLACK, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), false)

    map[Position(1, 2)] = Piece("Wknight1", Color.WHITE, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), false)
    map[Position(1, 7)] = Piece("Wknight2", Color.WHITE, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), false)
    map[Position(8, 2)] = Piece("Bknight1", Color.BLACK, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), false)
    map[Position(8, 7)] = Piece("Bknight2", Color.BLACK, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), false)

    map[Position(1, 3)] = Piece("Wbishop1", Color.WHITE, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), false)
    map[Position(1, 6)] = Piece("Wbishop2", Color.WHITE, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), false)
    map[Position(8, 3)] = Piece("Bbishop1", Color.BLACK, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), false)
    map[Position(8, 6)] = Piece("Bbishop2", Color.BLACK, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), false)

    map[Position(1, 4)] = Piece("Wqueen", Color.WHITE, PieceType.QUEEN, createClassicChessRules(PieceType.QUEEN), false)
    map[Position(1, 5)] = Piece("Wking", Color.WHITE, PieceType.KING, createClassicChessRules(PieceType.KING), false)
    map[Position(8, 4)] = Piece("Bqueen", Color.BLACK, PieceType.QUEEN, createClassicChessRules(PieceType.QUEEN), false)
    map[Position(8, 5)] = Piece("Bking", Color.BLACK, PieceType.KING, createClassicChessRules(PieceType.KING), false)

    return Board(map, 8, 8)
}

fun createCapablancaBoard(): Board {
    val map: MutableMap<Position, Piece> = mutableMapOf()

    for (i in 1..10){
        map[Position(2, i)] = Piece("Wpawn${i}", Color.WHITE, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), false)
        map[Position(7, i)] = Piece("Bpawn${i}", Color.BLACK, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), false)
    }

    map[Position(1, 1)] = Piece("Wrook1", Color.WHITE, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), false)
    map[Position(1, 10)] = Piece("Wrook2", Color.WHITE, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), false)
    map[Position(8, 1)] = Piece("Brook1", Color.BLACK, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), false)
    map[Position(8, 10)] = Piece("Brook2", Color.BLACK, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), false)

    map[Position(1, 2)] = Piece("Wknight1", Color.WHITE, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), false)
    map[Position(1, 9)] = Piece("Wknight2", Color.WHITE, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), false)
    map[Position(8, 2)] = Piece("Bknight1", Color.BLACK, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), false)
    map[Position(8, 9)] = Piece("Bknight2", Color.BLACK, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), false)

    map[Position(1, 3)] = Piece("Warcbishop1", Color.WHITE, PieceType.ARCHBISHOP, createClassicChessRules(PieceType.ARCHBISHOP), false)
    map[Position(1, 8)] = Piece("Wchancellor2", Color.WHITE, PieceType.CHANCELLOR, createClassicChessRules(PieceType.CHANCELLOR), false)
    map[Position(8, 3)] = Piece("Barcbishop1", Color.BLACK, PieceType.ARCHBISHOP, createClassicChessRules(PieceType.ARCHBISHOP), false)
    map[Position(8, 8)] = Piece("Bchancellor2", Color.BLACK, PieceType.CHANCELLOR, createClassicChessRules(PieceType.CHANCELLOR), false)

    map[Position(1, 4)] = Piece("Wbishop1", Color.WHITE, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), false)
    map[Position(1, 7)] = Piece("Wbishop2", Color.WHITE, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), false)
    map[Position(8, 4)] = Piece("Bbishop1", Color.BLACK, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), false)
    map[Position(8, 7)] = Piece("Bbishop2", Color.BLACK, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), false)

    map[Position(1, 5)] = Piece("Wqueen", Color.WHITE, PieceType.QUEEN, createClassicChessRules(PieceType.QUEEN), false)
    map[Position(1, 6)] = Piece("Wking", Color.WHITE, PieceType.KING, createClassicChessRules(PieceType.KING), false)
    map[Position(8, 5)] = Piece("Bqueen", Color.BLACK, PieceType.QUEEN, createClassicChessRules(PieceType.QUEEN), false)
    map[Position(8, 6)] = Piece("Bking", Color.BLACK, PieceType.KING, createClassicChessRules(PieceType.KING), false)

    return Board(map, 8, 10)
}