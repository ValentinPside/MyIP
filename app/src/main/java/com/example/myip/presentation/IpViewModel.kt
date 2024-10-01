package com.example.myip.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myip.R
import com.example.myip.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class IpViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val state = MutableStateFlow(IpState())
    fun observeUi() = state.asStateFlow()

    init {
        getIp()
    }

    private fun getIp() {
        viewModelScope.launch {
            try {
                val ip = repository.getMyIp()
                state.update { it.copy(ip = ip.myip, error = null) }
            } catch (e: Exception) {
                state.update { it.copy(error = R.string.error_message) }
            }
        }
    }
}

data class IpState(
    val ip: String? = null,
    val error: Int? = null
)