package com.simcodic.pincodegenerator.domain.pin_list

import kotlin.random.Random

interface PinGenerator {
    fun generate(pinSize: Int = 6): String
}

object SNRPinGenerator : PinGenerator {
    override fun generate(pinSize: Int): String {
        var s = ""
        for (i in 1..pinSize) {
            s += s.ifContainsThen()
        }
        return s
    }
}


private fun CharSequence.ifContainsThen(): String {
    val runNumber = getRunNumber()
    if (isEmpty()) {
        return runNumber
    }

    return if (contains(runNumber)) {
        ifContainsThen()
    } else {
        runNumber
    }
}

fun getRunNumber() = Random.nextInt(0, 9).toString()