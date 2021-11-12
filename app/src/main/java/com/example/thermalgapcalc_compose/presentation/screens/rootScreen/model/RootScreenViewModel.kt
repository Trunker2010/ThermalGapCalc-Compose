package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import com.example.thermalgapcalc_compose.domain.useCas.GetEngineMeasurementListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RootScreenViewModelViewModel @Inject constructor(
    private val getEngineMeasurementListUseCase: GetEngineMeasurementListUseCase,
) : ViewModel(), EventHandler<RootScreenEvent> {
    private val _rootScreenState =
        MutableLiveData<RootScreenState>(RootScreenState.Init)
    val rootScreenState: LiveData<RootScreenState> = _rootScreenState

    fun getList() {

        viewModelScope.launch {
            _rootScreenState.postValue(RootScreenState.Loading)
            withContext(Dispatchers.IO) {
                val list = getEngineMeasurementListUseCase.execute()
                if (list.isNotEmpty()) {
                    _rootScreenState.postValue(RootScreenState.Display(list))
                } else {
                    _rootScreenState.postValue(RootScreenState.Empty)
                }
            }
        }
    }

    override fun obtainEvent(event: RootScreenEvent) {
        when (val state = _rootScreenState.value) {
            is RootScreenState.Display -> {
                reduce(state, event)
            }
            is RootScreenState.Empty -> {
                reduce(state, event)
            }
            is RootScreenState.Loading -> {
                reduce(state, event)
            }
            is RootScreenState.Init -> {
                reduce(state, event)
            }
        }
    }

    private fun reduce(display: RootScreenState.Display, rootScreenEvent: RootScreenEvent) {
        when (rootScreenEvent) {
            is RootScreenEvent.LoadMeasurementList -> {
                getList()
            }
        }
    }

    fun reduce(display: RootScreenState.Init, rootScreenEvent: RootScreenEvent) {
        when (rootScreenEvent) {
            is RootScreenEvent.LoadMeasurementList -> {
                getList()
            }
        }
    }

    private fun reduce(display: RootScreenState.Loading, event: RootScreenEvent) {

    }

    private fun reduce(display: RootScreenState.Empty, rootScreenEvent: RootScreenEvent) {
        when (rootScreenEvent) {
            is RootScreenEvent.LoadMeasurementList -> {
                getList()
            }
        }
    }

}