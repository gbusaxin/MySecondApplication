package com.example.mysecondapplication.data.repository

import android.content.res.Resources
import androidx.core.os.ConfigurationCompat
import com.example.mysecondapplication.data.remote.ApiService
import com.example.mysecondapplication.data.remote.models.RequestDto
import com.example.mysecondapplication.domain.repository.ServerOrderOperation
import com.example.mysecondapplication.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class ServerOrderOperationImpl(
    private val apiService: ApiService
) : ServerOrderOperation {

    override suspend fun sendRequest(): Flow<DataState<String>> {
        return flow {
            emit(DataState.Loading)
            try {
                val locale = getLocale()
                val request = RequestDto(request = locale)
                val response = apiService.sendRequest(locale = request)
                if (response.url != "no") {
                    val encodedUrl = getEncodeUrl(response.url)
                    emit(DataState.Success(encodedUrl))
                } else {
                    emit(DataState.Error(Exception("Server's response is equal ${response.url}")))
                }
            } catch (e: Exception) {
                emit(DataState.Error(exception = e))
            }
        }
    }

    private fun getEncodeUrl(url: String): String {
        return URLEncoder.encode(
            url,
            StandardCharsets.UTF_8.toString()
        )
    }

    override fun getLocale(): String {
        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration)
        val lang = locale[0]
        return lang.isO3Language
    }

}