package com.codetoanbug.workapp

import android.view.LayoutInflater
import android.view.ViewGroup


import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codetoanbug.workapp.databinding.ItemWordBinding
import com.codetoanbug.workapp.model.Word

class WordsAdapter(private val interaction: Interaction? = null) :
    ListAdapter<Word, WordsAdapter.WordViewHolder>(WordDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordViewHolder (
        ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) = holder.bind(getItem(position))


    inner class WordViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Word) = with(binding) {
            binding.word = item
        }
    }

    interface Interaction {
    }

    private class WordDC : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }
    }
}
