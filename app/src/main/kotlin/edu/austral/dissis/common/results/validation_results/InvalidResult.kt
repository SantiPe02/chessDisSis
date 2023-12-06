package edu.austral.dissis.common.results.validation_results

data class InvalidResult(private val reason: String): ValidationResult {
    fun getReason(): String {
        return reason
    }
}