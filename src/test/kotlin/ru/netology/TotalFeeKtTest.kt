package ru.netology

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class TotalFeeKtTest {

    @Test
    fun totalFee_forVkPay() {
        val transfer = 10_000_00
        val typeCard: TypeCard = TypeCard.VkPay
        val transferPerMonth = 80_000_00

        val result = totalFee(
            amountOfTransfer = transfer,
            typeCard = typeCard,
            amountOfTransferPerMonth = transferPerMonth
        )

        assertEquals(0, result)
    }

    @Test
    fun totalFee_forVisaOrMirIfFalse() {
        val transfer = 10_000_00
        val typeCard: TypeCard = TypeCard.Mir
        val transferPerMonth = 80_000_00

        val result = totalFee(
            amountOfTransfer = transfer,
            typeCard = typeCard,
            amountOfTransferPerMonth = transferPerMonth
        )

        assertEquals(75_00, result)
    }

    @Test
    fun totalFee_forVisaOrMirIfTrue() {
        val transfer = 2_000_00
        val typeCard: TypeCard = TypeCard.Mir
        val transferPerMonth = 80_000_00

        val result = totalFee(
            amountOfTransfer = transfer,
            typeCard = typeCard,
            amountOfTransferPerMonth = transferPerMonth
        )

        assertEquals(35_00, result)
    }

    @Test
    fun totalFee_forMastercardOrMaestroIfTrue() {
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

    @Test
    fun totalFee_forMastercardOrMaestroIfFalsee() {
        val transfer = 10_000_00
        val typeCard: TypeCard = TypeCard.Mastercard
        val transferPerMonth = 10_000_00

        val result = totalFee(
            amountOfTransfer = transfer,
            typeCard = typeCard,
            amountOfTransferPerMonth = transferPerMonth
        )

        assertEquals(0, result)
    }
}