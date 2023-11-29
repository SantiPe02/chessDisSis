package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.chess.movement_rules.*
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Piece
import edu.austral.dissis.common.structure.Position

fun createNormalBoard(): Board {
    val map: MutableMap<Position, Piece> = mutableMapOf()

    for (i in 1..8){
        map[Position(2, i)] = Piece("Wpawn${i}", Color.WHITE, PieceType.PAWN, arrayListOf(PawnMove()), false)
        map[Position(7, i)] = Piece("Bpawn${i}", Color.BLACK, PieceType.PAWN, arrayListOf(PawnMove()), false)
    }

    map[Position(1, 1)] = Piece("Wrook1", Color.WHITE, PieceType.ROOK, arrayListOf(Straight()), false)
    map[Position(1, 8)] = Piece("Wrook2", Color.WHITE, PieceType.ROOK, arrayListOf(Straight()), false)
    map[Position(8, 1)] = Piece("Brook1", Color.BLACK, PieceType.ROOK, arrayListOf(Straight()), false)
    map[Position(8, 8)] = Piece("Brook2", Color.BLACK, PieceType.ROOK, arrayListOf(Straight()), false)

    map[Position(1, 2)] = Piece("Wknight1", Color.WHITE, PieceType.KNIGHT, arrayListOf(LForm()), false)
    map[Position(1, 7)] = Piece("Wknight2", Color.WHITE, PieceType.KNIGHT, arrayListOf(LForm()), false)
    map[Position(8, 2)] = Piece("Bknight1", Color.BLACK, PieceType.KNIGHT, arrayListOf(LForm()), false)
    map[Position(8, 7)] = Piece("Bknight2", Color.BLACK, PieceType.KNIGHT, arrayListOf(LForm()), false)

    map[Position(1, 3)] = Piece("Wbishop1", Color.WHITE, PieceType.BISHOP, arrayListOf(Diagonal()), false)
    map[Position(1, 6)] = Piece("Wbishop2", Color.WHITE, PieceType.BISHOP, arrayListOf(Diagonal()), false)
    map[Position(8, 3)] = Piece("Bbishop1", Color.BLACK, PieceType.BISHOP, arrayListOf(Diagonal()), false)
    map[Position(8, 6)] = Piece("Bbishop2", Color.BLACK, PieceType.BISHOP, arrayListOf(Diagonal()), false)

    map[Position(1, 4)] = Piece("Wqueen", Color.WHITE, PieceType.QUEEN, arrayListOf(Straight(), Diagonal()), false)
    map[Position(1, 5)] = Piece("Wking", Color.WHITE, PieceType.KING, arrayListOf(KingMove()), false)
    map[Position(8, 4)] = Piece("Bqueen", Color.BLACK, PieceType.QUEEN, arrayListOf(Straight(), Diagonal()), false)
    map[Position(8, 5)] = Piece("Bking", Color.BLACK, PieceType.KING, arrayListOf(KingMove()), false)

    return Board(map, 8, 8)
}