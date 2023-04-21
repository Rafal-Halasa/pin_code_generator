package com.simcodic.pincodegenerator.presentation.pins_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simcodic.pincodegenerator.domain.pin_list.SNRPinGenerator
import com.simcodic.pincodegenerator.domain.pin_list.SavePinInput
import com.simcodic.pincodegenerator.domain.pin_list.SavePinUseCase
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.PinsListViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PinsListViewModel @Inject constructor(val savePinUseCase: SavePinUseCase) : ViewModel() {

    private val _pinsListViewData = MutableStateFlow<PinsListViewData?>(null)
    val uiState = _pinsListViewData.asStateFlow()

    private val _showCreatePinDialog = MutableStateFlow(false)
    val showCreatePinDialog = _showCreatePinDialog.asStateFlow()

    fun onAddPinShowDialog() {
        _showCreatePinDialog.value = true
    }

    fun onCancelAddPinShowDialog() {
        _showCreatePinDialog.value = false
    }

    fun onAddPin() {
        viewModelScope.launch {
            withContext(coroutineContext) {
                runCatching {
                    savePinUseCase(SavePinInput(SNRPinGenerator.generate()))
                }.onSuccess {
                    _showCreatePinDialog.value = false
                }.onFailure {

                }
            }
        }
    }


    fun onDeletePin() {

    }
}