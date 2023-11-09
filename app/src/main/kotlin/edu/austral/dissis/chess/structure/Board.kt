package edu.austral.dissis.chess.structure


class Board(private var positions: Array<Position>) {

    fun getPositions(): Array<Position> {
        return positions
    }

    fun display(): String{
        var result = ""
        for (i in 0 until 64){
            if (i % 8 == 0){
                result += "\n"
            }
            if (positions[i].getPiece() == null){
                result += "NULL "
            }
            else{
                result += positions[i].getPiece()!!.getType().toString() + " "
            }
        }
        return result
    }
}
