package com.example.shiftapp.presentation.binDetailsFragment

import androidx.lifecycle.viewModelScope
import com.example.shiftapp.data.database.BinRepository
import com.example.shiftapp.domain.toUI
import com.example.shiftapp.presentation.base.BaseViewModel
import com.example.shiftapp.presentation.model.BinRequestUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class BinDetailsViewModel @Inject constructor(
    private val binRepository: BinRepository
): BaseViewModel() {
    var binId: UUID? = null
    private val _binRequestEntity: MutableStateFlow<BinRequestUI?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            _binRequestEntity.value = binId?.let { binRepository.getBin(it).toUI() }
        }
    }
}