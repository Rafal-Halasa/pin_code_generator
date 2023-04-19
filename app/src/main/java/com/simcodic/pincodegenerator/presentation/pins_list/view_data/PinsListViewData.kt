package com.simcodic.pincodegenerator.presentation.pins_list.view_data

data class PinsListViewData(val pinList: List<PinViewData>)

data class PinViewData(val name: String, val pin: String)
