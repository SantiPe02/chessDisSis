package edu.austral.dissis.checkers.factory.game

import edu.austral.dissis.checkers.factory.specific_rules.createClassicCheckersRules
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Piece
import edu.austral.dissis.common.structure.Position

fun createInitialCheckersBoard(): Board {
    val map: MutableMap<Position, Piece> = mutableMapOf()

    map[Position(1, 1)] = Piece("Wpawn1", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(1, 3)] = Piece("Wpawn2", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(1, 5)] = Piece("Wpawn3", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(1, 7)] = Piece("Wpawn4", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(2, 2)] = Piece("Wpawn5", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(2, 4)] = Piece("Wpawn6", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(2, 6)] = Piece("Wpawn7", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(2, 8)] = Piece("Wpawn8", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(3, 1)] = Piece("Wpawn9", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(3, 3)] = Piece("Wpawn10", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(3, 5)] = Piece("Wpawn11", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(3, 7)] = Piece("Wpawn12", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)

    map[Position(6, 2)] = Piece("Bpawn1", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(6, 4)] = Piece("Bpawn2", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(6, 6)] = Piece("Bpawn3", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(6, 8)] = Piece("Bpawn4", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(7, 1)] = Piece("Bpawn5", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(7, 3)] = Piece("Bpawn6", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(7, 5)] = Piece("Bpawn7", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(7, 7)] = Piece("Bpawn8", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(8, 2)] = Piece("Bpawn9", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(8, 4)] = Piece("Bpawn10", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(8, 6)] = Piece("Bpawn11", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)
    map[Position(8, 8)] = Piece("Bpawn12", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), false)

    return Board(map, 8, 8)
}