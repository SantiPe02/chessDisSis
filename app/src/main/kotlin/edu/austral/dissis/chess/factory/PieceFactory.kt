package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.enums.PieceType
import edu.austral.dissis.common.structure.Piece
import edu.austral.dissis.chess.enums.Color
import edu.austral.dissis.chess.movement_rules.*

fun createRook(color: Color): Piece {
    return Piece("rook", color, PieceType.ROOK, arrayListOf(Straight()), false)
}
fun createBishop(color: Color): Piece {
    return Piece("bishop", color, PieceType.BISHOP, arrayListOf(Diagonal()), false)
}
fun createKnight(color: Color): Piece {
    return Piece("knight", color, PieceType.KNIGHT, arrayListOf(LForm()), false)
}
fun createQueen(color: Color): Piece {
    return Piece("queen", color, PieceType.QUEEN, arrayListOf(Straight(), Diagonal()), false)
}
fun createKing(color: Color): Piece {
    return Piece("king", color, PieceType.KING, arrayListOf(KingMove()), false)
}
fun createPawn(color: Color): Piece {
    return Piece("pawn", color, PieceType.PAWN, arrayListOf(PawnMove()), false)
}