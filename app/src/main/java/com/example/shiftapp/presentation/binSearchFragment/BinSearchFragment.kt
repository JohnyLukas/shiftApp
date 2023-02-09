package com.example.shiftapp.presentation.binSearchFragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.shiftapp.R
import com.example.shiftapp.databinding.BinSearchFragmentBinding
import com.example.shiftapp.presentation.base.BaseFragment
import com.example.shiftapp.presentation.model.BinUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BinSearchFragment : BaseFragment(R.layout.bin_search_fragment) {
    private val binding: BinSearchFragmentBinding by viewBinding()
    override val viewModel: BinSearchViewModel by viewModels()

    private fun showNewResponse(binResponse: BinUI, binNumber: String) {
        findNavController().navigate(
            BinSearchFragmentDirections.actionToBinDetailsFragment(
                binResponse,
                binNumber,
                null
            )
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.handleErrorInput.collect { exception ->
                    exception?.let {
                        textInputBinNumberLayout.error = it
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.binResponse.collect { binItem ->
                    binItem?.let {
                        showNewResponse(
                            binResponse = it,
                            binNumber = textInputBinNumberEditText.text.toString()
                        )
                        viewModel.clearBinResponse()
                        textInputBinNumberEditText.text?.clear()
                    }
                }
            }
        }

        textInputBinNumberEditText.doAfterTextChanged {
            textInputBinNumberLayout.error = null
        }

        buttonEnter.setOnClickListener {
            viewModel.checkInputError(textInputBinNumberEditText.text.toString())
        }
    }

}