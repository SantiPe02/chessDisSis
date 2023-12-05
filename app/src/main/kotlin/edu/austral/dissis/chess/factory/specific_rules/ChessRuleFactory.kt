package edu.austral.dissis.chess.factory.specific_rules

import edu.austral.dissis.common.enums.PieceType
import edu.austral.dissis.common.movement_rules.AndRule
import edu.austral.dissis.common.movement_rules.EnemyAround
import edu.austral.dissis.common.movement_rules.MovementRule
import edu.austral.dissis.common.movement_rules.OrRule
import edu.austral.dissis.common.movement_rules.orientation.Diagonal
import edu.austral.dissis.common.movement_rules.orientation.HorizontalMove
import edu.austral.dissis.common.movement_rules.orientation.LMove
import edu.austral.dissis.common.movement_rules.orientation.VerticalMove
import edu.austral.dissis.common.movement_rules.qualities.HasMoved
import edu.austral.dissis.common.movement_rules.qualities.LimitedQuantity
import edu.austral.dissis.common.movement_rules.qualities.Obstacles
import edu.austral.dissis.common.movement_rules.qualities.OnlyForwardMovement

fun createClassicChessRules(type: PieceType): MovementRule {
        return when (type) {
            PieceType.PAWN -> classicPawnMovement()
            PieceType.ROOK -> classicRookMovement()
            PieceType.KNIGHT -> classicKnightMovement()
            PieceType.BISHOP -> classicBishopMovement()
            PieceType.QUEEN -> classicQueenMovement()
            PieceType.KING -> classicKingMovement()
        }
    }
    private fun classicPawnMovement(): MovementRule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        OnlyForwardMovement(),
                        LimitedQuantity(1),
                        VerticalMove(),
                        Obstacles(),
                        BlockedPawn()
                    )
                ),
                AndRule(
                    listOf(
                        OnlyForwardMovement(),
                        HasMoved(),
                        LimitedQuantity(2),
                        VerticalMove(),
                        Obstacles(),
                        BlockedPawn()
                    )
                ),
                AndRule(
                    listOf(
                        OnlyForwardMovement(),
                        LimitedQuantity(1),
                        Diagonal(),
                        Obstacles(),
                        EnemyAround()
                    )
                )
            )
        )
    }

    private fun classicRookMovement(): MovementRule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        VerticalMove(),
                        Obstacles()
                    )
                ),
                AndRule(
                    listOf(
                        HorizontalMove(),
                        Obstacles()
                    )
                )
            )
        )
    }

    private fun classicKnightMovement(): MovementRule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        LMove()
                    )
                )
            )
        )
    }

    private fun classicBishopMovement(): MovementRule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        Diagonal(),
                        Obstacles()
                    )
                )
            )
        )
    }

    private fun classicQueenMovement(): MovementRule {
        return OrRule(
            listOf(
                AndRule(
                    listOf(
                        VerticalMove(),
                        Obstacles()
                    )
                ),
                AndRule(
                    listOf(
                        HorizontalMove(),
                        Obstacles()
                    )
                ),
                AndRule(
                    listOf(
                        Diagonal(),
                        Obstacles()
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
                        VerticalMove(),
                        Obstacles()
                    )
                ),
                AndRule(
                    listOf(
                        LimitedQuantity(1),
                        HorizontalMove(),
                        Obstacles()
                    )
                ),
                AndRule(
                    listOf(
                        LimitedQuantity(1),
                        Diagonal(),
                        Obstacles()
                    )
                ),
                AndRule(
                    listOf(
                        RightCastlingCondition(),
                        Obstacles(),
                        HorizontalMove(),
                        LimitedQuantity(2)
                    )
                ),
                AndRule(
                    listOf(
                        LeftCastlingCondition(),
                        HorizontalMove(),
                        Obstacles(),
                        LimitedQuantity(2)
                    )
                )
            )
        )
    }