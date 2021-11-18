package com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.domain.model.toCylinderValveMeasurementState
import com.example.thermalgapcalc_compose.domain.useCas.GetMeasurementDetailsListUseCase
import com.example.thermalgapcalc_compose.presentation.data.CylinderState
import com.example.thermalgapcalc_compose.presentation.data.CylinderValveMeasurementState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SavedDetailsViewModel @Inject constructor(val getMeasurementDetailsListUseCase: GetMeasurementDetailsListUseCase) :
    ViewModel(),
    EventHandler<SavedDetailsScreenEvent> {
    private val _saveDetailsState =
        MutableLiveData<SavedDetailsScreenState>(SavedDetailsScreenState.Init)
    val saveDetailsState: LiveData<SavedDetailsScreenState> = _saveDetailsState
    override fun obtainEvent(event: SavedDetailsScreenEvent) {
        when (val state = _saveDetailsState.value) {
            is SavedDetailsScreenState.Init -> {
                reduce(state = state, savedDetailsScreenEvent = event)
            }
            SavedDetailsScreenState.Loading -> {

            }
            is SavedDetailsScreenState.Display -> {

            }
        }
    }

    private fun reduce(
        state: SavedDetailsScreenState.Init,
        savedDetailsScreenEvent: SavedDetailsScreenEvent
    ) {
        when (savedDetailsScreenEvent) {
            is SavedDetailsScreenEvent.LoadMeasurements -> {
                getDetailsList(savedDetailsScreenEvent.id)
            }
        }
    }

    private fun reduce(state: SavedDetailsScreenState.Loading, event: SavedDetailsScreenEvent) {

    }

    private fun reduce(state: SavedDetailsScreenState.Display, event: SavedDetailsScreenEvent) {

    }

    private fun reduce(state: SavedDetailsScreenState.Empty, event: SavedDetailsScreenEvent) {

    }

    private fun getDetailsList(id: String) {
        viewModelScope.launch {
            _saveDetailsState.postValue(SavedDetailsScreenState.Loading)
            withContext(Dispatchers.IO) {
                val list = getMeasurementDetailsListUseCase.execute(id = id)
                val convertedList = list.map { savedState ->
                    val cylinderState =
                        CylinderState(savedState.inValveList.size, savedState.exValveList.size)
                    val inList = mutableListOf<CylinderValveMeasurementState>()
                    val exList = mutableListOf<CylinderValveMeasurementState>()
                    savedState.exValveList.forEach {
                        exList.add(it.toCylinderValveMeasurementState())
                    }
                    savedState.inValveList.forEach {
                        inList.add(it.toCylinderValveMeasurementState())
                    }
                    cylinderState.inValveList = inList
                    cylinderState.exValveList = exList
                    cylinderState
                }
                if (list.isNotEmpty()) {
                    _saveDetailsState.postValue(SavedDetailsScreenState.Display(convertedList))
                } else {
                    _saveDetailsState.postValue(SavedDetailsScreenState.Empty)
                }

            }
        }
    }


}