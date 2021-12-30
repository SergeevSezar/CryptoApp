package app.crypto.cryptoapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import app.crypto.cryptoapp.R
import app.crypto.cryptoapp.databinding.ItemCoinInfoBinding
import app.crypto.cryptoapp.domain.CoinInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(private val context: Context
) : ListAdapter<CoinInfo, CoinInfoViewHolder>(CoinInfoDiffCallback) {

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
       val binding = ItemCoinInfoBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       )
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder.binding) {
            with(coin) {
                val symbolsTemplate = context.resources.getString(R.string.symbols_template)
                val lastUpdTemplate = context.resources.getString(R.string.symbols_last_upd)
                tvSymbols.text = String.format(symbolsTemplate, fromSymbol, toSymbol)
                tvPrice.text = price.toString()
                tvTimeLastUpd.text = String.format(lastUpdTemplate, lastUpdate)
                Picasso.get().load(imageUrl).into(ivLogoCoin)
                root.setOnClickListener {
                    onCoinClickListener?.onClick(coin)
                }
            }
        }
    }

    interface OnCoinClickListener {
        fun onClick(coinPriceInfo: CoinInfo)
    }
}