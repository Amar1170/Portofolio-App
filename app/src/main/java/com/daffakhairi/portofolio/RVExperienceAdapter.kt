package com.daffakhairi.portofolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daffakhairi.portofolio.databinding.ItemExperienceBinding
import java.util.*

class RVExperienceAdapter :RecyclerView.Adapter<RVExperienceAdapter.ExperienceViewHolder>() {


    private val listData = ArrayList<Portofolio>()
    var onItemClicked : ((Portofolio) -> Unit)? = null

    fun setData(newList: List<Portofolio>?){
        if (newList == null) return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder =
        ExperienceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        )

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val listData = listData[position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int = listData.size


    inner class ExperienceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemExperienceBinding.bind(itemView)

        fun bind(data: Portofolio){
            binding.experience = data
            binding.executePendingBindings()
        }


        init {
            binding.root.setOnClickListener{
                onItemClicked?.invoke(listData[adapterPosition])
            }
        }
    }
}