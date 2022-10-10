package com.example.mvvmproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.mvvmproject.R
import com.example.mvvmproject.databinding.FragmentNumberBinding
import com.example.mvvmproject.local.NumberViewModel
import com.example.mvvmproject.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberFragment : Fragment() {

    lateinit var binding: FragmentNumberBinding
    private val  viewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumberBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            val number = binding.editText.text.toString().trim().toInt()
            viewModel.getNumberFact(number)
        }

        // ViewModel observer not woking
        /*viewModel.fact.observe(viewLifecycleOwner) {
            when (it?.getContentIfNotHandled()?.status) {
                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progress.visibility = View.INVISIBLE
                    binding.numberFact.text = it.peekContent().data?.text
                }
                Status.ERROR -> {
                   binding.progress.visibility = View.INVISIBLE
                }
                else -> {}
            }
        }*/
    }
}