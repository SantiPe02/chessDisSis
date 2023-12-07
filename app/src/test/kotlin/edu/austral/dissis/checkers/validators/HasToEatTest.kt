package edu.austral.dissis.checkers.validators

import edu.austral.dissis.checkers.util.boardWithPawnCanEat
import edu.austral.dissis.common.enums.Color
import edu.austral.dissis.common.results.validation_results.ValidResult
import edu.austral.dissis.common.structure.Movement
import edu.austral.dissis.common.structure.Position
import org.junit.Test
import org.junit.jupiter.api.Assertions

class HasToEatTest {
    @Test
    fun hasToEatTest() {
        val board = boardWithPawnCanEat()
        val movement = Movement(Position(3, 3), Position(4, 2), Color.WHITE, board)
        Assertions.assertTrue(HasToEat().validate(movement, board) !is ValidResult)
    }
}