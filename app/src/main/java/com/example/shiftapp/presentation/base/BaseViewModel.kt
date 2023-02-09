package com.example.shiftapp.presentation.base

import androidx.lifecycle.ViewModel
import com.example.shiftapp.data.net.common.NetworkException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    protected val _handleError: MutableStateFlow<NetworkException?> = MutableStateFlow(null)
    val handleError: StateFlow<NetworkException?> = _handleError.asStateFlow()
}