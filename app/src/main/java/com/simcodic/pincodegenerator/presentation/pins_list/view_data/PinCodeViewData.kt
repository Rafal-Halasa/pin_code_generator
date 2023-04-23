package com.simcodic.pincodegenerator.presentation.pins_list.view_data

import com.simcodic.pincodegenerator.domain.data.PinCode

data class PinCodeViewData(val id: Int = 0, val name: String, val pinCode: String)

fun PinCodeViewData.toDomainModel() = PinCode(id = id, name = name, pinCode = pinCode)