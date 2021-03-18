package com.example.moviesapp.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    lateinit var fragmentLoginBinding:FragmentLoginBinding

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().setTitle(R.string.login)
        fragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)
        fragmentLoginBinding.viewmodel = loginViewModel

        fragmentLoginBinding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                loginViewModel.onEmailTextChange(s.toString())
            }

        })


        fragmentLoginBinding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                loginViewModel.onPasswordTextChange(s.toString())
            }

        })

        fragmentLoginBinding.btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_movieListFragment)
        }

        return fragmentLoginBinding.root
    }
}