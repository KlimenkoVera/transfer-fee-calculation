package ru.netology

enum class TypeCard {
    Mastercard, Maestro, Visa, Mir, VkPay
}

const val MIN_FEE = 35_00
const val LIMIT = 75_000_00

fun main () {
val result = totalFee (amountOfTransfer = 2_000_00, amountOfTransferPerMonth = 75_000_00, typeCard = TypeCard.Maestro)


    println("Ваша комиссия за перевод составит: $result копеек")
}

fun userCardToFee (
    typeCard: TypeCard = TypeCard.VkPay
): Double = when (typeCard) {
    TypeCard.VkPay -> .0
    TypeCard.Mir, TypeCard.Visa -> .0075
    TypeCard.Maestro, TypeCard.Mastercard -> .006
}

fun totalFee (
    amountOfTransfer: Int,
    amountOfTransferPerMonth: Int = 0,
    typeCard: TypeCard = TypeCard.VkPay
): Int {
val fee = (userCardToFee(typeCard) * amountOfTransfer).toInt()
val totalPay = amountOfTransfer + amountOfTransferPerMonth
  return  when (typeCard) {
        TypeCard.VkPay -> fee
        TypeCard.Mir, TypeCard.Visa -> if (fee < MIN_FEE) MIN_FEE else fee
        TypeCard.Mastercard,  TypeCard.Maestro -> if (totalPay > LIMIT) fee else 0
    }

}
