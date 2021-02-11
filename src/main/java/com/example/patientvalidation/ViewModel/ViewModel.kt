package com.example.patientvalidation.ViewModel

import android.text.Editable
import android.text.TextWatcher
import com.example.patientvalidation.textinputvalidation
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ViewModel {


    fun ValidateEmail(email: TextInputEditText) {
        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!textinputvalidation.isValidEmail(email.text.toString())) {
                    email.error = "email address is not valid"
                    email.requestFocus()
                }
            }

        })


    }

    fun Validatenumber(phonenumber: TextInputEditText) {
        phonenumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!textinputvalidation.isValidMobile(phonenumber.text.toString())) {
                    phonenumber.error = "Must be a valid Phone number"
                    phonenumber.requestFocus()
                }
            }

        })

    }
}