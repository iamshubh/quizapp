package com.skay.quizapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skay.quizapp.databinding.ItemOptionBinding

class QuizAdapter(private val items: List<Char>, private val onclick: ((Char) -> Unit)) :
    RecyclerView.Adapter<QuizAdapter.PostViewHolder>() {


    inner class PostViewHolder(private val binding: ItemOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(d: Char) {
            binding.apply {
                tvItem.text = d.toString()
                root.setOnClickListener {
                    onclick(d)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(items[position])
    }
}