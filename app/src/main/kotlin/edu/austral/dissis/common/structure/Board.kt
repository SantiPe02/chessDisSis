package edu.austral.dissis.common.structure

import edu.austral.dissis.common.enums.Color


class Board(private var positions: Map<Position, Piece>, private val row: Int, private val col: Int) {

    fun makeMove(from: Position, to: Position): Board {
        if(!positions.containsKey(from)) return this
        val piece = positions[from]!!
        return Board(positions + Pair(to, piece.copy(
            hasMoved = true
        )) - from, row, col)
    }

    fun getPositions(): Map<Position, Piece> {
        return positions
    }

    fun getPiece(position: Position): Piece? {
        return positions[position]
    }

    fun getPieceAt(x: Int, y: Int): Piece? {
        for (key in positions.keys){
            if (key.getRow() == x && key.getColumn() == y){
                return positions[key]
            }
        }
        return null
    }

    fun getRow(): Int {
        return row
    }

    fun getCol(): Int {
        return col
    }

    fun getWhitePieces(): List<Piece> {
        val whitePieces = mutableListOf<Piece>()
        for ((_, piece) in this.getPositions()) {
            if (piece.getColor() == Color.WHITE) whitePieces.add(piece)
        }
        return whitePieces
    }

    fun getBlackPieces(): List<Piece> {
        val blackPieces = mutableListOf<Piece>()
        for ((_, piece) in this.getPositions()) {
            if (piece.getColor() == Color.BLACK) blackPieces.add(piece)
        }
        return blackPieces
    }

    fun addPiece(piece: Piece, position: Position): Board {
        return Board(positions + Pair(position, piece), row, col)
    }

    fun removePiece(position: Position): Board {
        return Board(positions - position, row, col)
    }
}
