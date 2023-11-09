package edu.austral.dissis.chess.structure

import edu.austral.dissis.chess.enums.Color

class Player(private val name: String, private val color: Color) {
    fun getColor(): Color {
        return color
    }

    fun getName(): String {
        return name
    }
}