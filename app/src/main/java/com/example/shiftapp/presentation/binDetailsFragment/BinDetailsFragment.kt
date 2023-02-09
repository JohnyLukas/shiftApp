package com.example.shiftapp.presentation.binDetailsFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.shiftapp.presentation.base.BaseFragment
import com.example.shiftapp.R
import com.example.shiftapp.databinding.BinDetailsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BinDetailsFragment : BaseFragment(R.layout.bin_details_fragment) {
    private val binding: BinDetailsFragmentBinding by viewBinding()
    private val args: BinDetailsFragmentArgs by navArgs()
    override val viewModel: BinDetailsViewModel by lazy {
        val viewModel: BinDetailsViewModel by viewModels()
        viewModel.binId = args.binId
        viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        numberLength.text = getString(
            R.string.length,
            args.currentBinList.numberUI?.length ?: getString(R.string.unknown)
        )

        numberLuhn.text = getString(
            R.string.luhn,
            args.currentBinList.numberUI?.luhn ?: getString(R.string.unknown)
        )

        cardScheme.text = getString(
            R.string.scheme,
            args.currentBinList.scheme
        )

        cardType.text = getString(
            R.string.type,
            args.currentBinList.type
        )

        cardBrand.text = getString(
            R.string.brand,
            args.currentBinList.brand
        )

        cardPrepaid.text = getString(
            R.string.prepaid,
            args.currentBinList.prepaid ?: getString(R.string.unknown)
        )

        countryNumeric.text = getString(
            R.string.numeric,
            args.currentBinList.countryUI?.numeric ?: R.string.unknown
        )

        countryAlpha2.text = getString(
            R.string.alpha2,
            args.currentBinList.countryUI?.alpha2 ?: R.string.unknown
        )

        countryName.text = getString(
            R.string.name,
            args.currentBinList.countryUI?.name ?: R.string.unknown
        )

        countryName.setOnClickListener {
            val mapIntent = Intent()
            mapIntent.action = Intent.ACTION_VIEW
            mapIntent.data = Uri.parse(
                "geo:${args.currentBinList.countryUI?.latitude}," +
                        " ${args.currentBinList.countryUI?.longitude}"
            )
            startActivity(mapIntent)
        }

        countryEmoji.text = getString(
            R.string.emoji,
            args.currentBinList.countryUI?.emoji ?: R.string.unknown
        )

        countryCurrency.text = getString(
            R.string.currency,
            args.currentBinList.countryUI?.currency ?: R.string.unknown
        )

        countryLatitude.text = getString(
            R.string.latitude,
            args.currentBinList.countryUI?.latitude ?: getString(R.string.unknown)
        )

        countryLongitude.text = getString(
            R.string.longitude,
            args.currentBinList.countryUI?.longitude ?: getString(R.string.unknown)
        )

        bankName.text = getString(
            R.string.bank_name,
            args.currentBinList.bankUI?.name ?: R.string.unknown
        )

        bankUrl.text = getString(
            R.string.url,
            args.currentBinList.bankUI?.url ?: R.string.unknown
        )

        bankUrl.setOnClickListener {
            val browseIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://${args.currentBinList.bankUI?.url}")
            )
            startActivity(browseIntent)
        }

        bankPhone.text = getString(
            R.string.phone,
            args.currentBinList.bankUI?.phone ?: R.string.unknown
        )

        bankPhone.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL)
            phoneIntent.data = Uri.parse("tel: ${args.currentBinList.bankUI?.phone}")
            startActivity(phoneIntent)
        }

        bankCity.text = getString(
            R.string.city,
            args.currentBinList.bankUI?.city ?: R.string.unknown
        )
    }
}