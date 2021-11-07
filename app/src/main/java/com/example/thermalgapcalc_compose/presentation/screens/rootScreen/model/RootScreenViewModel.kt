package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thermalgapcalc_compose.domain.useCas.GetEngineMeasurementListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RootScreenViewModelViewModel @Inject constructor(
    private val getEngineMeasurementListUseCase: GetEngineMeasurementListUseCase,
) : ViewModel(
) {
    fun getList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val list = getEngineMeasurementListUseCase.execute()
                Log.d("getList", list[0].cylindersList.toString())
            }
        }
    }
}