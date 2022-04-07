package io.softpay.presentation.transaction.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.softpay.sdk.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import java.lang.Exception

class TransactionViewModel(private val transactionManager: TransactionManager) : ViewModel(),
    KoinComponent {

    sealed class Event {
        object OpenConfirmScreen : Event()
    }

    var isProcessing: Boolean by mutableStateOf(false)
        private set

    var showKeyBoard: Boolean by mutableStateOf(false)
        private set

    var amountValue: String by mutableStateOf("")
        private set

    var showCancelTransactionButton: Boolean by mutableStateOf(false)
        private set

    var isAwaitingConfirmation: Boolean by mutableStateOf(false)
        private set

    var storeDetails: Store? by mutableStateOf(null)
        private set

    private var currentTransactionFlow: Flow<Transaction>? = null
    private var currentState: State? = null
    private var amountEntered: Long = 0
    private val currency = "kr."

    init {
        updateAmount()
        viewModelScope.launch {
            try {
                startTransaction()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun startTransaction() {
        if (currentTransactionFlow == null) {
            currentTransactionFlow = transactionManager.newTransactionFlow()

            currentTransactionFlow?.collect {
                currentState = it.state
                showKeyBoard = it.state == State.AWAITING_AMOUNT
                isProcessing = it.state == State.PROCESSING
                showCancelTransactionButton = it.state == State.PROCESSING && amountEntered > 0
                isAwaitingConfirmation = it.state == State.AWAITING_CONFIRMATION

                it.store?.let { store -> storeDetails = store }

                when (it.state) {
                    State.SUCCESS -> {
                    }
                    State.FAILURE -> {
                    }
                    State.CANCELLED -> {
                    }
                }
            }
        }
    }

    private fun updateAmount(amount: Long = 0) {
        viewModelScope.launch {
            amountEntered = amount
            amountValue = formatAmount(amount)
        }
    }

    private fun formatAmount(amount: Long): String {
        val amountAsString = "$amount"
        val amountValue = when {
            amountAsString.length < 2 -> {
                "0,0$amountAsString"
            }
            amountAsString.length < 3 -> {
                "0,$amountAsString"
            }
            else -> {
                StringBuilder(amountAsString).insert(amountAsString.length - 2, ",").toString();
            }
        }
        return "$amountValue $currency"
    }

    fun digitEntered(digit: Int) {
        if (amountEntered.toString().length > 9) return
        updateAmount(("$amountEntered${digit.toLong()}").toLong())
    }

    fun digitDeleted() {
        val amountEntered = amountEntered.toString()
        val updatedAmount = amountEntered.substring(0, amountEntered.lastIndex)
        updateAmount(if (updatedAmount.isEmpty()) 0 else updatedAmount.toLong())
    }

    fun submit() {
        if (currentState != State.AWAITING_AMOUNT) return
        viewModelScope.launch {
            try {
                transactionManager.dispatch(Input.Amount(amountEntered))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}