package app.crypto.cryptoapp.data.network

import app.crypto.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import app.crypto.cryptoapp.data.network.model.CoinNamesListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
   suspend fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "22b03245f84b308d7b4e7b4c25404e923b67f9829e19be92ab24d252296320cf",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
    ): CoinNamesListDto

    @GET("pricemultifull")
   suspend fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "22b03245f84b308d7b4e7b4c25404e923b67f9829e19be92ab24d252296320cf",
        @Query(QUERY_PARAM_FROM_SYMBOL) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tsyms: String = CURRENCY
    ): CoinInfoJsonContainerDto

    companion object{
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOL = "fsyms"

        private const val CURRENCY = "USD"
    }
}