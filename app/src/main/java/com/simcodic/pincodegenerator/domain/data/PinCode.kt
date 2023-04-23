package com.simcodic.pincodegenerator.domain.data

import com.simcodic.pincodegenerator.presentation.pins_list.view_data.PinCodeViewData
import com.simcodic.pincodegenerator.data.data.PinCode as PinCodeEntity

data class PinCode(val id: Int = 0, val name: String, val pinCode: String)

fun PinCode.toEntity() = PinCodeEntity(uid = id, name = name, pinCode = pinCode)

fun PinCode.toViewData() = PinCodeViewData(id = id, name = name, pinCode = pinCode)