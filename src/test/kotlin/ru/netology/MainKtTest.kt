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

    @Test
    fun userCardToFee_forVkPay() {

        val expectedResult = .0

        val result = userCardToFee(typeCard = TypeCard.VkPay)

        assertEquals(expectedResult, result, 0.0)
    }

    @Test
    fun userCardToFee_forVisaOrMir() {

        val expectedResult = .0075

        val result = userCardToFee(typeCard = TypeCard.Visa)

        assertEquals(expectedResult, result, 0.0)
    }

    @Test
    fun userCardToFee_forMastercardOrMaestro() {

        val expectedResult = .006

        val result = userCardToFee(typeCard = TypeCard.Mastercard)

        assertEquals(expectedResult, result, 0.0)
    }
}
