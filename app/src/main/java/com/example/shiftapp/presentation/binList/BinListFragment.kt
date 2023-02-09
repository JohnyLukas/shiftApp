package com.example.shiftapp.presentation.binList

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.shiftapp.R
import com.example.shiftapp.databinding.FragmentBinListBinding
import com.example.shiftapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BinListFragment : BaseFragment(R.layout.fragment_bin_list), MenuProvider {
    override val viewModel: BinListViewModel by viewModels()
    private val binding: FragmentBinListBinding by viewBinding()
    private val binListAdapter = BinListAdapter {binId ->
        findNavController().navigate(
            BinListFragmentDirections
                .actionBinListFragmentTobinDetailsFragment(
                    viewModel.findBinById(binId)!!,
                    null,
                    binId
                )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.binRecycleView.layoutManager = LinearLayoutManager(context)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.bins.collect { bins ->
                    binListAdapter.updateDataSet(bins)
                    binding.binRecycleView.adapter = binListAdapter
                }
            }
        }
    }

    override fun onCreateMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_bin_list, menu)
    }

    override fun onMenuItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.newResponse -> {
                findNavController().navigate(
                    BinListFragmentDirections.actionToBinSearchFragment()
                )
                true
            }
            else -> false
        }
    }
}