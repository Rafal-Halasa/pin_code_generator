package com.simcodic.pincodegenerator.domain.pin_list.generators

import kotlin.random.Random

interface PinGenerator {
    fun generate(pinSize: Int = 6): String
}

object SNRPinGenerator : PinGenerator {
    override fun generate(pinSize: Int): String {
        var stringValue = ""
        for (i in 1..pinSize) {
            stringValue += stringValue.ifContainsThen()
        }
        return stringValue
    }
}


private fun CharSequence.ifContainsThen(): String {
    val runNumber = getRunNumber()
    if (isEmpty()) {
        return runNumber
    }

    return if (count { it.toString() == runNumber } == 3) {
        ifContainsThen()
    } else {
        runNumber
    }
}

fun getRunNumber() = Random.nextInt(0, 9).toString()