package com.example.shemajamebeli6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli6.databinding.FragmentMainBinding


class MainFragment : Fragment() {



    private lateinit var binding : FragmentMainBinding

    private val myAdapter = RecyclerAdapter()

    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        init()
        return binding.root
    }

    private fun init(){
        initRecycler()
        initClick()
        viewModel.read()
        observe()

    }

    fun initRecycler(){
        binding.myRecycler.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initClick(){
        binding.regisBtn.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }
    }


    private fun observe(){
        viewModel._users.observe(viewLifecycleOwner){
            myAdapter.getData(it)
        }


    }


}