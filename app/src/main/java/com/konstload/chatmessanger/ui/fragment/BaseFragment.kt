package com.konstload.chatmessanger.ui.fragment

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.konstload.chatmessanger.R
import com.konstload.chatmessanger.domain.type.exception.Failure
import com.konstload.chatmessanger.ui.activity.BaseActivity
import com.konstload.chatmessanger.ui.activity.base
import javax.inject.Inject

/**
 * Базовый класс для выделения общего поведения фрагментов
 */
abstract class BaseFragment : Fragment() {

    abstract val layoutId: Int

    open val titleToolbar = R.string.app_name
    open val showToolbar = true

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onResume() {
        super.onResume()

        base {
            if (showToolbar) supportActionBar?.show() else supportActionBar?.hide()
            supportActionBar?.title = getString(titleToolbar)
        }
    }

    open fun onBackPressed() {}

    fun showProgress() = base{ progressStatus(View.VISIBLE)}
    fun hideProgress() = base{ progressStatus(View.GONE)}

    fun hideSoftKeyboard() = base { hideSoftKeyboard() }

    fun handleFailure(failure: Failure?) = base { handleFailure(failure) }

    fun showMessage(message: String) = base { showMessage(message) }

    private inline fun base(block: BaseActivity.() -> Unit) {
        activity.base(block)
    }

    inline fun <reified T: ViewModel> viewModel(body: T.() -> Unit): T {
        val vm = ViewModelProviders.of(this, viewModelFactory)[T::class.java]
        vm.body()
        return vm
    }

    fun close() = fragmentManager?.popBackStack()
}