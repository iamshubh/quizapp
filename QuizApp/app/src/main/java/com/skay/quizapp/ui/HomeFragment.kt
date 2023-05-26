package com.skay.quizapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.skay.quizapp.R
import com.skay.quizapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.initQuizGames()
    }

    private fun initView() {
        observers()
    }

    private fun observers() {
        viewModel.items.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                setUpQuizList()
            }
        }
    }

    private fun setUpQuizList() {
        binding.rvOptions.apply {
            val items = ('A'..'Z').map { it }
            adapter = QuizAdapter(items, ::onItemClick)
            layoutManager = GridLayoutManager(requireContext(), 6)
        }
    }

    fun onItemClick(input: Char) {
        val curr = binding.tvAnswer.text.toString()
        if (curr.length < 5) {
            binding.tvAnswer.text = "$curr$input"
        } else {
            // length 5
            viewModel.handleNextQuestion()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}