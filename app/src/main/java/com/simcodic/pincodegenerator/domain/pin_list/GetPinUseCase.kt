package com.simcodic.pincodegenerator.domain.pin_list

import com.simcodic.pincodegenerator.data.data.toDomainModel
import com.simcodic.pincodegenerator.data.repositories.local.dao.PinCodeDao
import com.simcodic.pincodegenerator.domain.base.UseCaseUsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.simcodic.pincodegenerator.domain.data.PinCode as PinCodeDomainModel

class GetPinUseCase @Inject constructor(private val pinCodeDao: PinCodeDao) : UseCaseUsFlow<Flow<List<PinCodeDomainModel>?>> {

    override suspend fun run(): Flow<List<PinCodeDomainModel>> = pinCodeDao.getAll().map {
        it.map { it.toDomainModel() }
    }
}

