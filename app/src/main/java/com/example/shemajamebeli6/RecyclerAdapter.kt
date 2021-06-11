package com.example.shemajamebeli6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shemajamebeli6.databinding.RecyclerLayoutBinding

class RecyclerAdapter(): RecyclerView.Adapter<RecyclerAdapter.ViewHolderr>() {


    private var itemsList = listOf<User>()

    inner class ViewHolderr(private val binding: RecyclerLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){
            binding.title.text = itemsList[adapterPosition].title.toString()
            binding.description.text = itemsList[adapterPosition].description.toString()
            getImg (itemsList[adapterPosition].image.toString())
            binding.deleteBtn.setOnClickListener {

            }
        }

        fun getImg (url:String){
            Glide.with(binding.root.context).load(url).into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderr {
        return ViewHolderr(RecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderr, position: Int) {
       holder.bind()
    }

    override fun getItemCount()=itemsList.size

    fun getData(list:List<User>){
        itemsList = list
        notifyDataSetChanged()
    }




}