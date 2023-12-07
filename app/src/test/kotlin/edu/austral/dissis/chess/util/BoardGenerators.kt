package edu.austral.dissis.chess.util

import edu.austral.dissis.chess.factory.specific_rules.createClassicChessRules
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Piece
import edu.austral.dissis.common.structure.Position

fun kingIsInCheck(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("king1", Color.WHITE, PieceType.KING, createClassicChessRules(PieceType.KING), true),
            Position(1,2) to Piece("rook1", Color.BLACK, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), true),
        ), 8,8)
}

fun kingIsInCheckmate(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("king1", Color.WHITE, PieceType.KING, createClassicChessRules(PieceType.KING), true),
            Position(1,2) to Piece("rook1", Color.BLACK, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), true),
            Position(3,2) to Piece("rook2", Color.BLACK, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), true),
            Position(8, 8) to Piece("king2", Color.BLACK, PieceType.KING, createClassicChessRules(PieceType.KING), true),
        ), 8,8)
}

fun boardWithPawnAlone(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("pawn1", Color.WHITE, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), true),
        ), 8,8)
}

fun boardWithPawnHasNoMoves(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("pawn1", Color.WHITE, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), false),
        ), 8,8)
}

fun boardWithPawnPossibilityToEat(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("pawn1", Color.WHITE, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), true),
            Position(2,2) to Piece("pawn2", Color.BLACK, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), true),
        ), 8,8)
}

fun boardWithRookAlone(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("rook1", Color.WHITE, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), true),
        ), 8,8)
}

fun boardWithRookAndPieceBetween(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("rook1", Color.WHITE, PieceType.ROOK, createClassicChessRules(PieceType.ROOK), true),
            Position(1,2) to Piece("pawn2", Color.BLACK, PieceType.PAWN, createClassicChessRules(PieceType.PAWN), true),
        ), 8,8)
}

fun boardWithKnightAlone(): Board {
    return Board(
        mapOf(
            Position(1,2) to Piece("knight1", Color.WHITE, PieceType.KNIGHT, createClassicChessRules(PieceType.KNIGHT), true),
        ), 8,8)
}

fun boardWithQueenAlone(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("queen1", Color.WHITE, PieceType.QUEEN, createClassicChessRules(PieceType.QUEEN), true),
        ), 8,8)
}

fun kingInTheMiddleAlone(): Board {
    return Board(
        mapOf(
            Position(4,4) to Piece("king1", Color.WHITE, PieceType.KING, createClassicChessRules(PieceType.KING), true),
        ), 8,8)
}

fun boardWithBishopAlone(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("bishop1", Color.WHITE, PieceType.BISHOP, createClassicChessRules(PieceType.BISHOP), true),
        ), 8,8)
}