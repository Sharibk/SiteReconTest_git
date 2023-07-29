package com.example.siterecontest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MeowFactsAdapter (private val facts: List<String>) :
    RecyclerView.Adapter<MeowFactsAdapter.MeowFactViewHolder>() {

        inner class MeowFactViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
            private val facttextView : TextView = itemView.findViewById(R.id.textView)

            fun bind(fact : String){
                facttextView.text = fact
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeowFactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_meow_fact,parent,false)
        return MeowFactViewHolder(view)
    }

    override fun getItemCount(): Int {
       return facts.size
    }

    override fun onBindViewHolder(holder: MeowFactViewHolder, position: Int) {
       holder.bind(facts[position])
    }

}