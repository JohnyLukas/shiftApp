package com.example.shiftapp.presentation.binList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shiftapp.data.model.entity.BinRequestEntity
import com.example.shiftapp.data.model.entity.toUI
import com.example.shiftapp.databinding.ListItemBinBinding
import com.example.shiftapp.presentation.model.BinRequestUI
import java.text.DateFormat
import java.util.*

class BinListAdapter (
    private val onBinClicked: (binId: UUID) -> Unit
) : RecyclerView.Adapter<BinListAdapter.BinHolder>() {

    private var binListUI: List<BinRequestEntity> = emptyList()
    fun updateDataSet(bins: List<BinRequestEntity>){
        binListUI = bins
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinBinding.inflate(inflater, parent, false)
        return BinHolder(binding)
    }

    override fun onBindViewHolder(holder: BinHolder, position: Int) {
        val bin = binListUI[position]
        holder.bind(bin.toUI())
    }

    override fun getItemCount() = binListUI.size

    inner class BinHolder(
        private val binding: ListItemBinBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(binRequestUI: BinRequestUI) {
            binding.binNumber.text = binRequestUI.binNumber

            binding.responseDate.text =
                DateFormat.getDateInstance(DateFormat.FULL).format(binRequestUI.date).toString()

            binding.root.setOnClickListener {
                this@BinListAdapter.onBinClicked(binRequestUI.id)
            }
        }
    }
}