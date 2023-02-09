package com.example.shiftapp.presentation.binSearchFragment

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewModelScope
import com.example.shiftapp.data.net.common.NetworkException
import com.example.shiftapp.domain.useCase.GetBinDetailsUseCase
import com.example.shiftapp.domain.useCase.GetBinDetailsUseCaseParams
import com.example.shiftapp.domain.toUI
import com.example.shiftapp.presentation.base.BaseViewModel
import com.example.shiftapp.presentation.model.BinUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinSearchViewModel @Inject constructor(
    private val getBinDetailsUseCase: GetBinDetailsUseCase
) : BaseViewModel() {

    private val _handleErrorInput: MutableStateFlow<String?> = MutableStateFlow(null)
    val handleErrorInput: StateFlow<String?> = _handleErrorInput.asStateFlow()

    private val _binResponse: MutableStateFlow<BinUI?> = MutableStateFlow(null)

    val binResponse: StateFlow<BinUI?> = _binResponse.asStateFlow()

    fun checkInputError(binNumber: String?) {
        when {
            binNumber == null -> _handleErrorInput.value = "Please enter your BIN number"
            binNumber.length in 4..8 && binNumber.isDigitsOnly() -> {
                _handleErrorInput.value = null
                getInfoByNumbers(binNumber)
            }
            binNumber.length < 4 -> _handleErrorInput.value = "Please enter min 4 digits"
            binNumber.length > 8 -> _handleErrorInput.value = "You entered more than 8 characters"
            else -> _handleErrorInput.value = "Please entered only digits"
        }
    }

    private fun getInfoByNumbers(binNumber: String) {
        viewModelScope.launch {
            getBinDetailsUseCase.invoke(
                param = GetBinDetailsUseCaseParams(binNumber = binNumber)
            ).collect { result ->
                result.onSuccess { bin ->
                    _binResponse.value = bin.toUI()
                }.onFailure { throwable ->
                    _handleError.value = throwable.localizedMessage?.let {
                        NetworkException(
                            title = throwable.message.toString(),
                            description = throwable.toString()
                        )
                    }
                }
            }
        }
    }

    fun clearBinResponse() {
        _binResponse.value = null
    }

}