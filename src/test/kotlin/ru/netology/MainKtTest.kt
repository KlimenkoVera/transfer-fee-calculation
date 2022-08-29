package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun totalFee_forVkPay() {
        val transfer = 10_000_00
        val typeCard: TypeCard = TypeCard.VkPay
        val transferPerMonth = 0

        val result = totalFee(
            amountOfTransfer = transfer,
            typeCard = typeCard,
            amountOfTransferPerMonth = transferPerMonth
        )

        assertEquals(10, result)
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
        val typeCard: TypeCard = TypeCard.Visa
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
    fun totalFee_forMastercardOrMaestroIfFalse() {
        val transfer = 10_000_00
        val typeCard: TypeCard = TypeCard.Maestro
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

        val typeCard: TypeCard = TypeCard.VkPay
        val expectedResult = .0

        val result = userCardToFee(typeCard = typeCard)

        assertEquals(expectedResult, result, 0.0)
    }

    @Test
    fun userCardToFee_forVisaOrMir() {

        val typeCard: TypeCard = TypeCard.Visa
        val expectedResult = .0075

        val result = userCardToFee(typeCard = typeCard)

        assertEquals(expectedResult, result, 0.0)
    }


    @Test
    fun userCardToFee_forMastercardOrMaestro() {

        val typeCard: TypeCard = TypeCard.Mastercard
        val expectedResult = .006

        val result = userCardToFee(typeCard = typeCard)

        assertEquals(expectedResult, result, 0.0)
    }

}
