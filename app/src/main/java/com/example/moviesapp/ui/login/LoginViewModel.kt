package com.example.moviesapp.ui.login

import android.app.Application
import android.util.Patterns
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(application: Application) : AndroidViewModel(application){
    private var isValidEmail = false
    private var isValidPassword = false
    private val submitButtonEnableObservableField: ObservableField<Boolean> = ObservableField()


    fun getSubmitButtonEnableObservableField() = submitButtonEnableObservableField

    fun onEmailTextChange(email: String) {
        isValidEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (isValidEmail && isValidPassword) {
            submitButtonEnableObservableField.set(true)
        } else {
            submitButtonEnableObservableField.set(false)
        }
    }

    fun onPasswordTextChange(password: String) {
        isValidPassword = (password.length in 7..11)
        if (isValidPassword && isValidEmail) {
            submitButtonEnableObservableField.set(true)
        } else {
            submitButtonEnableObservableField.set(false)
        }
    }


}