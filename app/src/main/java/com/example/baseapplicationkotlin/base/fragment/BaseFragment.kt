package com.example.baseapplicationkotlin.base.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.baseapplicationkotlin.base.di.ScopeAware
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import timber.log.Timber


abstract class BaseFragment : Fragment() {

    protected val logger
        get() = Timber.tag(this::class.java.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (this is ScopeAware) {
            // bind "custom" scope to component lifecycle
            bindScope(scope = getOrCreateScope(scopeId), event = scopedLifecycleEvent)
        }
    }
}

//fun Fragment.findParentNavController() = Navigation.findNavController(requireActivity(), R.id.navHostFragment)