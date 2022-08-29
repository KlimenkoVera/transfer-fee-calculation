package ru.netology

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class UserCardKtTest {
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