package com.simcodic.pincodegenerator.domain.pin_list

interface PinGenerator {
    fun generate(): String
}

object SNRPinGenerator : PinGenerator {
    override fun generate(): String = "dasd"
}