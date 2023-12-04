package edu.austral.dissis.checkers.factory.specific_rules

import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.movement_rules.AndRule
import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.movement_rules.NoEnemyAround
import edu.austral.dissis.common.movement_rules.OrRule
import edu.austral.dissis.common.movement_rules.orientation.Diagonal
import edu.austral.dissis.common.movement_rules.qualities.LimitedQuantity
import edu.austral.dissis.common.movement_rules.qualities.OnlyForwardMovement

fun createClassicCheckersRules(type: PieceType): MovementRule {
        return when (type) {
            PieceType.PAWN -> classicPawnMovement()
            PieceType.KING -> classicKingMovement()
            else -> {
                throw Exception("Invalid piece type")
            }
        }
    }
    private fun classicPawnMovement(): MovementRule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        OnlyForwardMovement(),
                        LimitedQuantity(1),
                        Diagonal(),
                        NoEnemyAround()
                    )
                ),
                AndRule(
                    listOf(
                        OnlyForwardMovement(),
                        LimitedQuantity(2),
                        Diagonal(),
                        NoEnemyAround(),
                        IsEating()
                    )
                )
            )
        )
    }

    private fun classicKingMovement(): MovementRule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        LimitedQuantity(1),
                        Diagonal(),
                        NoEnemyAround()
                    )
                ),
                AndRule(
                    listOf(
                        LimitedQuantity(2),
                        Diagonal(),
                        NoEnemyAround(),
                        IsEating()
                    )
                )
            )
        )
    }