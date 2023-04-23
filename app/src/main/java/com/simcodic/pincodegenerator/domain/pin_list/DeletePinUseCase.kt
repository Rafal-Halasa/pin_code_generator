package com.simcodic.pincodegenerator.domain.pin_list

import com.simcodic.pincodegenerator.data.repositories.local.dao.PinCodeDao
import com.simcodic.pincodegenerator.domain.base.UseCase
import com.simcodic.pincodegenerator.domain.base.UseCaseData
import com.simcodic.pincodegenerator.domain.data.PinCode
import com.simcodic.pincodegenerator.domain.data.toEntity
import javax.inject.Inject

class DeletePinUseCase @Inject constructor(private val pinCodeDao: PinCodeDao) : UseCase<DeletePinInput, UseCaseData.NonOutput> {

    override suspend fun run(input: DeletePinInput): UseCaseData.NonOutput {
        pinCodeDao.delete(input.pinCode.toEntity())
        return UseCaseData.NonOutput
    }
}

data class DeletePinInput(val pinCode: PinCode) : UseCaseData.Input