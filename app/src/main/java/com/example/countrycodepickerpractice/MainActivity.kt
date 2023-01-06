package com.example.countrycodepickerpractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.hbb20.CountryCodePicker

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ccp=findViewById<CountryCodePicker>(R.id.country_code_picker)
        val countryName=findViewById<TextView>(R.id.country_label)
        val countryCode=findViewById<TextView>(R.id.countrycode)


        ccp.setOnCountryChangeListener {
            countryName.text=ccp.selectedCountryName.toString()
            countryCode.text="+"+ccp.selectedCountryCode.toString()

        }
    }
}