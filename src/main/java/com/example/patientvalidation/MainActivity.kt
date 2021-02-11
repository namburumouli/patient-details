package com.example.patientvalidation

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.patientvalidation.ViewModel.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.usergender)
        val adapter = ArrayAdapter.createFromResource(this, R.array.SelectGender, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        var selectdate=findViewById<Button>(R.id.userdateofbirth)
        var textView=findViewById<TextView>(R.id.userage)
        var phonenumber=findViewById<TextInputEditText>(R.id.usernumber)
        var email=findViewById<TextInputEditText>(R.id.useremail)
        var submit=findViewById<Button>(R.id.loginButton)
        var name=findViewById<TextInputEditText>(R.id.username)
        var comments=findViewById<EditText>(R.id.commentstext)
        var age=findViewById<TextInputEditText>(R.id.userage)


        ViewModel().ValidateEmail(email)
        ViewModel().Validatenumber(phonenumber)




        //calender
        var c=Calendar.getInstance()
        var cyear=c.get(Calendar.YEAR)
        var cmonth=c.get(Calendar.MONTH)
        var cday=c.get(Calendar.DAY_OF_MONTH)
        // button clicke to show calender
        selectdate.setOnClickListener(){
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                cyear=year
                cmonth=monthOfYear
                cday=dayOfMonth
                // Display Selected date in textbox
                val currentyear=Calendar.getInstance()
                    .get(Calendar.YEAR)
                val age=currentyear-cyear
                textView.text="$age"

            }, cyear, cmonth, cday)
            dpd.show()
        }

        submit.setOnClickListener{
            val patientname:String=name.text.toString()
            val entercommentstext:String=comments.text.toString()
            val useremail:String=email.text.toString()
            val usernumber :String=phonenumber.text.toString()
            var age:String=age.text.toString()
            if (patientname.length<=0 || entercommentstext.length<=0 || useremail.length<=0 ||usernumber.length<=0 ||age.length<=0  ){
                Toast.makeText(applicationContext, "cannot be empty ", Toast.LENGTH_SHORT).show()

            }

        }

    }




}

