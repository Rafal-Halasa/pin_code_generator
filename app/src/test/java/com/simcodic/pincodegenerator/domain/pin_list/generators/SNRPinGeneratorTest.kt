package com.simcodic.pincodegenerator.domain.pin_list.generators

import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SNRPinGeneratorTest {

    @Test
    fun initSNRPinGenerator_whenGenerate_thenLengthIsSix() {
        val generate = SNRPinGenerator.generate()
        generate.length shouldBe 6
    }

    @Test
    fun initSNRPinGenerator_whenGenerate500Codes_thenLengthIsSix() {
        for (index in 0..500) {
            val generate = SNRPinGenerator.generate()
            for (char in generate.toCharArray()) {
                generate.count { it == char } shouldBeLessThan 4
            }
        }
    }
}