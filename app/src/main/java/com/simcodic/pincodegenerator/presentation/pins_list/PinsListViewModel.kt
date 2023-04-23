package com.simcodic.pincodegenerator.presentation.pins_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simcodic.pincodegenerator.domain.data.PinCode
import com.simcodic.pincodegenerator.domain.data.toViewData
import com.simcodic.pincodegenerator.domain.pin_list.*
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.PinCodeViewData
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.toDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PinsListViewModel @Inject constructor(
    val savePinUseCase: SavePinUseCase,
    val getPinUseCase: GetPinUseCase,
    val deletePinUseCase: DeletePinUseCase,
) : ViewModel() {

    private val _pinsListViewData = MutableStateFlow<List<PinCodeViewData>?>(null)
    val uiState = _pinsListViewData.asStateFlow()

    private val _showCreatePinDialog = MutableStateFlow(false)
    val showCreatePinDialog = _showCreatePinDialog.asStateFlow()

    init {
        viewModelScope.launch {
            getPinUseCase().collect {
                _pinsListViewData.value = it?.map { it.toViewData() }
            }
        }
    }

    fun onAddPinShowDialog() {
        _showCreatePinDialog.value = true
    }

    fun onCancelAddPinShowDialog() {
        _showCreatePinDialog.value = false
    }

    fun onAddPin() {
        viewModelScope.launch {
            runCatching {
                savePinUseCase(SavePinInput(PinCode(name = "name", pinCode = SNRPinGenerator.generate())))
            }.onSuccess {
                _showCreatePinDialog.value = false
            }.onFailure {

            }
        }
    }


    fun onDeletePin(pinCodeViewData: PinCodeViewData) {
        viewModelScope.launch {
            deletePinUseCase(DeletePinInput(pinCode = pinCodeViewData.toDomainModel()))
        }
    }
}