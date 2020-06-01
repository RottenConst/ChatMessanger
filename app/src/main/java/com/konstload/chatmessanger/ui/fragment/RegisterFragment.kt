package com.konstload.chatmessanger.ui.fragment

import android.os.Bundle
import android.view.View
import com.konstload.chatmessanger.R
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.presentation.viewmodel.AccountViewModel
import com.konstload.chatmessanger.ui.App
import com.konstload.chatmessanger.ui.ext.onFailure
import com.konstload.chatmessanger.ui.ext.onSuccess
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * Фрагмент для отображения регистрации
 */
class RegisterFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_register
    override val titleToolbar = R.string.register

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)

        accountViewModel = viewModel {
            onSuccess(registerData, ::handleRegister)
            onFailure(failureData, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNewMembership.setOnClickListener {
            register()
        }
    }

    private fun validateFields(): Boolean {
        val allFields = arrayOf(etEmail, etPassword, etConfirmPassword, etUserName)
        var allValid = true
        for (field in allFields){
            allValid = field.testValidity() && allValid
        }
        return allValid && validatePassword()
    }

    private fun validatePassword(): Boolean {
        val valid = etPassword.text.toString() == etConfirmPassword.text.toString()
        if (!valid) {
            showMessage(getString(R.string.error_password_mismatch))
        }
        return valid
    }

    private fun register() {
        hideSoftKeyboard()
        val allValid = validateFields()

        if (allValid) {
            showProgress()

            accountViewModel.register(
                etEmail.text.toString(),
                etUserName.text.toString(),
                etPassword.text.toString()
            )
        }
    }

    private fun handleRegister(none: None? = None()) {
        hideProgress()
        showMessage("Аккаунт создан")
    }
}