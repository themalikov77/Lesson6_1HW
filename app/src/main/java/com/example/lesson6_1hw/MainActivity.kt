package com.example.lesson6_1hw

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson6_1hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data : Intent? = result.data
                binding.etFirst.setText(data?.getStringExtra(RESUlT))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        binding.btnNext.setOnClickListener {
            if (binding.etFirst.text.isEmpty()) {
                showToast(this)
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(RESUlT, binding.etFirst.text.toString())
                resultLauncher.launch(intent)
            }
        }
    }

    companion object {
        const val RESUlT = "key"
    }
}