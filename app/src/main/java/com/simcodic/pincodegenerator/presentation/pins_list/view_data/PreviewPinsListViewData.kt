package com.simcodic.pincodegenerator.presentation.pins_list.view_data

fun previewPinsListViewData() =
    PinsListViewData(
        listOf(
            PinViewData("pin1", "123456"),
            PinViewData("pin2", "243456"),
            PinViewData("pin3", "134563"),
            PinViewData("My lovely pin for my secret box", "134563")
        )
    )