package com.codetoanbug.workapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.codetoanbug.workapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WordsViewModel by viewModels()
    private var wordAdapter = WordsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()
        binding.addWordFab.setOnClickListener {
            showAddWordDialog()
        }

        viewModel.getAllWords().observe(this) { words ->
            wordAdapter.submitList(words)
        }
    }

    private fun setupRecyclerView() {
        binding.wordsRecyclerView.apply {
            wordAdapter = WordsAdapter()
            layoutManager = LinearLayoutManager(this@WordActivity)
            adapter = wordAdapter
        }
    }

    private fun showAddWordDialog() {
        MaterialDialog(this).show {
            input { dialog, text ->
                viewModel.insertWord(text.toString()).observe(this@WordActivity) { success ->
                    if (success) {
                       Toast.makeText(this@WordActivity, "Word added", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@WordActivity, "Error adding word", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            positiveButton(text = "submit")
        }
    }
}