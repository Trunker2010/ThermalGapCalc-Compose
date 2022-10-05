package com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.domain.useCas.GetMeasurementDetailsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SavedCalcViewModel @Inject constructor(val getMeasurementDetailsListUseCase: GetMeasurementDetailsListUseCase) :
    ViewModel(), EventHandler<SavedEvent> {
    private val _viewState = MutableLiveData<SavedCalcState>(SavedCalcState.Init)
    val viewState: LiveData<SavedCalcState> = _viewState
    override fun obtainEvent(event: SavedEvent) {
        when (val state = _viewState.value) {
           is SavedCalcState.Init -> {
                reduce(state, event)
            }
            is SavedCalcState.Display -> TODO()
            SavedCalcState.Empty -> TODO()
            SavedCalcState.Loading -> TODO()
            null -> TODO()
        }
    }

    fun reduce(state: SavedCalcState.Init, event: SavedEvent) {
        when (event) {
            is SavedEvent.LoadMeasurementList -> {
                loadMeasurementsList(event.id)
            }
        }
    }

    private fun loadMeasurementsList(id: String) {
        _viewState.postValue(SavedCalcState.Loading)
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val list = getMeasurementDetailsListUseCase.execute(id)
                _viewState.postValue(SavedCalcState.Display(list))
            }
        }
    }
}