package io.softpay.splashscreen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class SplashScreenViewModel : ViewModel(), KoinComponent {
    var appReady: Boolean by mutableStateOf(false)
        private set

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val events = eventChannel.receiveAsFlow()

    sealed class Event {
        object StartApp: Event()
    }

    init {
        viewModelScope.launch {
            delay(3000)
            appReady = true
            eventChannel.send(Event.StartApp)
        }
    }
}