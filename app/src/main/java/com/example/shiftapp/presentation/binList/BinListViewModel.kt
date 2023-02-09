package com.example.shiftapp.presentation.binList

import androidx.lifecycle.viewModelScope
import com.example.shiftapp.data.model.entity.BinRequestEntity
import com.example.shiftapp.data.database.BinRepository
import com.example.shiftapp.data.model.entity.toUI
import com.example.shiftapp.presentation.base.BaseViewModel
import com.example.shiftapp.presentation.model.BinUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class BinListViewModel @Inject constructor(
    private val binRepository: BinRepository
): BaseViewModel() {
    private val _bins: MutableStateFlow<List<BinRequestEntity>> = MutableStateFlow(emptyList())
    val bins: StateFlow<List<BinRequestEntity>> = _bins

    init {
        viewModelScope.launch {
            binRepository.getBins().collect { binList ->
                _bins.value = binList
            }
        }
    }

    fun findBinById(id: UUID): BinUI? {
        val bin = bins.value.find { it.id == id }
        return bin?.bin?.toUI()
    }
}