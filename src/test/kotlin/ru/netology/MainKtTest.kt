package ru.netology

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun main() {
        val transfer = 10_000_00
        val typeCard: TypeCard = TypeCard.Mastercard
        val transferPerMonth = 80_000_00

        val result = totalFee(
            amountOfTransfer = transfer,
            typeCard = typeCard,
            amountOfTransferPerMonth = transferPerMonth
        )

        assertEquals(60_00, result)
    }

}
