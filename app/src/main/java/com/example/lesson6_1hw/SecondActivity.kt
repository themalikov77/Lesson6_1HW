package com.example.lesson6_1hw

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson6_1hw.MainActivity.Companion.RESUlT
import com.example.lesson6_1hw.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
        binding.etSecond.setText(intent.getStringExtra(RESUlT))
    }

    private fun initClicker() {
        binding.btnBack.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(RESUlT, binding.etSecond.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}