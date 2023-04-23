package com.simcodic.pincodegenerator.domain.pin_list

import com.simcodic.pincodegenerator.data.repositories.local.dao.PinCodeDao
import com.simcodic.pincodegenerator.domain.base.UseCase
import com.simcodic.pincodegenerator.domain.base.UseCaseData
import com.simcodic.pincodegenerator.domain.data.PinCode
import com.simcodic.pincodegenerator.domain.data.toEntity
import javax.inject.Inject

class SavePinUseCase @Inject constructor(private val pinCodeDao: PinCodeDao) : UseCase<SavePinInput, UseCaseData.NonOutput> {

    override suspend fun run(input: SavePinInput): UseCaseData.NonOutput {
        pinCodeDao.insert(input.pinCode.toEntity())
        return UseCaseData.NonOutput
    }
}

data class SavePinInput(val pinCode: PinCode) : UseCaseData.Input