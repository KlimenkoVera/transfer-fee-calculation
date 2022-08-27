package ru.netology

fun main () {
    val amount = 2_000_00
    val transferFee = 75 
    val feeStart = 4_666_67
    val minFee = 35_00

    val totalFee = if (amount > feeStart) amount * transferFee/10000 else minFee

    println("Ваша комиссия за перевод составит: $totalFee")
}