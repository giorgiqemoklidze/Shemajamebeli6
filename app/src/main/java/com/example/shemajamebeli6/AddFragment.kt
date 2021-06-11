package com.example.shemajamebeli6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shemajamebeli6.databinding.FragmentAddBinding


class AddFragment : Fragment() {



    private lateinit var binding : FragmentAddBinding

    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater,container,false)
        init()
        return binding.root
    }

    private fun init(){

        initCliclListeners()

    }

    private fun initCliclListeners(){

        binding.submit.setOnClickListener{
            viewModel.write(binding.title.text.toString(),binding.description.text.toString(),binding.url.text.toString())
            findNavController().navigateUp()
        }
    }

}