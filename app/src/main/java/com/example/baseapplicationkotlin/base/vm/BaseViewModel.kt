package com.example.baseapplicationkotlin.base.vm

import androidx.lifecycle.ViewModel
import org.koin.standalone.KoinComponent
import timber.log.Timber


abstract class BaseViewModel : ViewModel(), KoinComponent {

    protected val logger
        get() = Timber.tag(this::class.java.simpleName)

}