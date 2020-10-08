package com.timilehinaregbesola.kredit.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.timilehinaregbesola.kredit.HomeActivity
import com.timilehinaregbesola.kredit.LenderActivity
import com.timilehinaregbesola.kredit.R
import com.timilehinaregbesola.kredit.databinding.FragmentLoginBinding
import com.timilehinaregbesola.kredit.databinding.FragmentLoginFullBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtSwitchAccount.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToNewLoginFragment())
        }
        binding.btnSignin.setOnClickListener {
            val password = binding.edtPassword.editText?.text.toString().trim()

            when {
                password.isBlank() -> {
                    Toast.makeText(requireContext(), "Please fill in a password", Toast.LENGTH_SHORT).show()
                }
                password == "000000" -> {
                    startActivity(Intent(requireActivity(), HomeActivity::class.java))
                    requireActivity().finish()
                }
                else -> {
                    Toast.makeText(requireContext(), "Credentials incorrect!! Check password", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}