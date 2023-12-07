package edu.austral.dissis.checkers.util

import edu.austral.dissis.checkers.factory.specific_rules.createClassicCheckersRules
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.structure.Board
import edu.austral.dissis.common.structure.Piece
import edu.austral.dissis.common.structure.Position

fun kingTestingBoardWithPawn(): Board {
    return Board(
        mapOf(
            Position(1, 1) to Piece("king1", Color.WHITE, PieceType.KING, createClassicCheckersRules(PieceType.KING), true),
            Position(2, 2) to Piece("pawn1", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
        ), 8, 8)
}

fun kingTestingBoardAlone(): Board {
    return Board(
        mapOf(
            Position(1, 1) to Piece(
                "king1",
                Color.WHITE,
                PieceType.KING,
                createClassicCheckersRules(PieceType.KING),
                true
            )
        ), 8, 8)
}

fun boardWithPawnAlone(): Board {
    return Board(
        mapOf(
            Position(1,1) to Piece("pawn1", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
        ), 8,8)
}

fun boardWithPawnCanEat(): Board {
    return Board(
        mapOf(
            Position(3, 3) to Piece("pawn1", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
            Position(4,4) to Piece("pawn2", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
        ), 8,8)
}

fun boardWithTwoPossibleEatings(): Board {
    return Board(
        mapOf(
            Position(3, 3) to Piece("pawn1", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
            Position(4,4) to Piece("pawn2", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
            Position(6, 6) to Piece("pawn3", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
        ), 8,8)
}

fun boardAfterFirstEating(): Board {
    return Board(
        mapOf(
            Position(5, 5) to Piece("pawn1", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
            Position(6,6) to Piece("pawn2", Color.BLACK, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
        ), 8,8)
}

fun boardAfterSecondEating(): Board {
    return Board(
        mapOf(
            Position(7, 7) to Piece("pawn1", Color.WHITE, PieceType.PAWN, createClassicCheckersRules(PieceType.PAWN), true),
        ), 8,8)
}