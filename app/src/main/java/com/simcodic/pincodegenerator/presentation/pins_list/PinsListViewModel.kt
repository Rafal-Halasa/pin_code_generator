package com.simcodic.pincodegenerator.presentation.pins_list

import androidx.lifecycle.ViewModel
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.PinsListViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PinsListViewModel @Inject constructor() : ViewModel() {
    private val _pinsListViewData = MutableStateFlow<PinsListViewData?>(null)
    val uiState = _pinsListViewData.asStateFlow()
}