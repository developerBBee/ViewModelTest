package jp.developer.bbee.viewmodeltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import jp.developer.bbee.viewmodeltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.textCounter.text = viewModel.counter.toString()

        binding.btnUp.setOnClickListener {
            if (viewModel.counter < 10000) {
                viewModel.counter++
                binding.textCounter.text = viewModel.counter.toString()
            }
        }
        binding.btnDown.setOnClickListener {
            if (viewModel.counter != 0) {
                viewModel.counter--
                binding.textCounter.text = viewModel.counter.toString()
            }
        }
    }
}