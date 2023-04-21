package com.simcodic.pincodegenerator.domain.pin_list

import com.simcodic.pincodegenerator.domain.base.UseCase
import com.simcodic.pincodegenerator.domain.base.UseCaseData
import javax.inject.Inject

class SavePinUseCase @Inject constructor() : UseCase<SavePinInput, UseCaseData.NonOutput> {

    override fun run(input: SavePinInput): UseCaseData.NonOutput {
        return UseCaseData.NonOutput
    }
}

data class SavePinInput(val name: String) : UseCaseData.Input