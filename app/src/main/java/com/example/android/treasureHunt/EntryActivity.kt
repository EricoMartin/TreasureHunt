package com.example.android.treasureHunt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android.treasureHunt.databinding.ActivityEntryBinding
import com.google.android.material.textfield.TextInputLayout

class EntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEntryBinding
    private lateinit var textInput: TextInputLayout
    private lateinit var textInput1: TextInputLayout
    private lateinit var textInput2: TextInputLayout
    private lateinit var textInput3: TextInputLayout
    private lateinit var textInput4: TextInputLayout
    private lateinit var textInput5: TextInputLayout
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textInput = binding.textInputLayout

        textInput1 = binding.textInput

        textInput2 = binding.textInputLayout2

        textInput3 = binding.textInputlay

        textInput4 = binding.textInputLayout3

        textInput5 = binding.textInputlay1

        button = binding.button

        val firstLatitude = textInput.editText?.text
        val firstLongitude = textInput1.editText?.text

        val secondLatitude = textInput2.editText?.text
        val secondLongitude = textInput3.editText?.text

        val thirdLatitude = textInput4.editText?.text
        val thirdLongitude = textInput5.editText?.text

        button.setOnClickListener {
            if (firstLatitude.isNullOrEmpty()) {
                textInput.isErrorEnabled = true
                textInput.error = "Enter Valid Latitude"
            }
            if (firstLongitude.isNullOrEmpty()) {
                textInput1.isErrorEnabled = true
                textInput1.error = "Enter Valid Longitude"
            }
            if (secondLatitude.isNullOrEmpty()) {
                textInput2.isErrorEnabled = true
                textInput2.error = "Enter Valid Latitude"
            }
            if (secondLongitude.isNullOrEmpty()) {
                textInput3.isErrorEnabled = true
                textInput3.error = "Enter Valid Longitude"
            }
            if (thirdLatitude.isNullOrEmpty()) {
                textInput4.isErrorEnabled = true
                textInput4.error = "Enter Valid Longitude"
            }
            if (thirdLongitude.isNullOrEmpty()) {
                textInput5.isErrorEnabled = true
                textInput5.error = "Enter Valid Latitude"
            }
            val intent = Intent(this, HuntMainActivity::class.java)

            val lat1 = firstLatitude.toString()
            val long1 = firstLongitude.toString()

            val lat2 = secondLatitude.toString()
            val long2 = secondLongitude.toString()

            val lat3 = thirdLatitude.toString()
            val long3 = thirdLongitude.toString()

            if (lat1 == "" || lat2 == ""
                || lat3 == "" || long1 == ""
                || long2 == "" || long3 == ""
            ) {
                return@setOnClickListener
//                startActivity(Intent(this, EntryActivity::class.java))
            }

            intent.putExtra("firstLatitude", lat1.toDouble())
            intent.putExtra("firstLongitude", long1.toDouble())

            intent.putExtra("secondLatitude", lat2.toDouble())
            intent.putExtra("secondLongitude", long2.toDouble())

            intent.putExtra("thirdLatitude", lat3.toDouble())
            intent.putExtra("thirdLongitude", long3.toDouble())

            startActivity(intent)

        }
    }
}