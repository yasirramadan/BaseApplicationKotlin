package com.example.baseapplicationkotlin.base.vm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

abstract class BaseScopedViewModel : BaseViewModel(), CoroutineScope {

    // A failure or cancellation of a child does not cause the supervisor job to fail and does not affect its other children.
    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()

        coroutineContext.cancelChildren()
    }
}