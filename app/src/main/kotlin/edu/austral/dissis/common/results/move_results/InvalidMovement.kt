package edu.austral.dissis.common.results.move_results

class InvalidMovement(private val reason: String): MoveResult {
    fun getReason(): String {
        return reason
    }
}