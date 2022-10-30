package com.example.dztechpark

import android.graphics.Color.BLUE
import android.graphics.Color.RED
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val numbers: List<Int>,
) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_number_item, null)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(numbers[position])
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberTextView: TextView = itemView.findViewById(R.id.number_text_view)


        fun bind(number: Int) {
            numberTextView.text = number.toString()
            if (number % 2 == 1)
                numberTextView.setBackgroundColor(BLUE)
            else
                numberTextView.setBackgroundColor(RED)

        }
    }
}