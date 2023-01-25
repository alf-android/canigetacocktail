package com.alagunas.canigetacocktail.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.alagunas.canigetacocktail.databinding.ActivityMainBinding
import com.alagunas.canigetacocktail.viewmodels.CocktailDetailViewModel
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CocktailDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            Toast.makeText(this, "saving to database...", Toast.LENGTH_SHORT).show()
            viewModel.setCocktail(binding.etEntry.text.toString())
        }

        binding.btnGetLast.setOnClickListener {
            viewModel.getAllCocktails()

        }

        binding.btnGoToNextScreen.setOnClickListener {
            startActivity(Intent(this, CocktailDetailActivity::class.java))
        }

        observe(viewModel.showCocktail) { cocktail ->
            if (cocktail != null) {
                binding.tvResult.text = "${cocktail.name} (${cocktail.id}) total: ${cocktail.description}"
            }
        }
    }
}

inline fun <T> AppCompatActivity.observe(flow: Flow<T>, crossinline observer: (T) -> Unit) {
    lifecycleScope.launchWhenStarted {
        flow.collect { observer(it) }
    }
}