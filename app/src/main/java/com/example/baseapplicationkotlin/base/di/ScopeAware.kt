package com.example.baseapplicationkotlin.base.di

import androidx.lifecycle.Lifecycle


interface ScopeAware {

    val scopeId: String

    val scopedLifecycleEvent: Lifecycle.Event
        get() = Lifecycle.Event.ON_DESTROY
}