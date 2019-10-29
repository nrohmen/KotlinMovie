package com.nrohmen.kotlinmovie.network

import com.nrohmen.kotlinmovie.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by root on 11/15/17.
 */
internal class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url = originalUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                .build()
        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}