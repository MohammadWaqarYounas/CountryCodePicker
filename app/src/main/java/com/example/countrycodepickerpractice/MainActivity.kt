package com.example.countrycodepickerpractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.hbb20.CCPCountry
import com.hbb20.CountryCodePicker

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countriesList=CCPCountry.getLibraryMasterCountryList(this,CountryCodePicker.Language.ENGLISH)


        val ccp=findViewById<CountryCodePicker>(R.id.country_code_picker)
        val countryName=findViewById<TextView>(R.id.country_label)
        val countryCode=findViewById<TextView>(R.id.countrycode)
        val countrySearch=findViewById<EditText>(R.id.et_country_search)
        val button=findViewById<Button>(R.id.search_button)


        ccp.setOnCountryChangeListener {
            countryName.text=ccp.selectedCountryName.toString()
            countryCode.text="+"+ccp.selectedCountryCode.toString()
        }
        val countries=ccp.selectedCountryName
        val search=findViewById<AutoCompleteTextView>(R.id.search_bar)

        val adapter = ArrayAdapter(this, R.layout.listitem_design, countriesList)
        search.threshold=1
         search.setAdapter(adapter)


        button.setOnClickListener{
            val result=countrySearch.text.toString()
            for (country in countriesList){
                if (country.name.equals(result)){
                    Log.d("mansoor","Country Name : $result, and Country Code : ${country.nameCode}")
                    ccp.setCountryForNameCode(country.nameCode)

                }
            }


        }
    }
}