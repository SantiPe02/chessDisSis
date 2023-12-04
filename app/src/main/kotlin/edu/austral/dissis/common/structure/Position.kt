package edu.austral.dissis.common.structure


class Position(private val row: Int, private val column: Int) {
    fun getRow(): Int {
        return row
    }

    fun getColumn(): Int {
        return column
    }
}
