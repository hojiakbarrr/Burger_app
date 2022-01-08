package com.example.burger_app

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burger_app.TypeAdapter.*

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class TypeAdapter(
    private val list: ArrayList<BurgerType>,
    private val clickListener: PlusClickListener
) : RecyclerView.Adapter<TypeHolder>() {
    var temp: Boolean = false


    inner class TypeHolder(item: View) : RecyclerView.ViewHolder(item) {

        var nameOfBurger: TextView = itemView.findViewById(R.id.textView8)
        var price: TextView = itemView.findViewById(R.id.textView6)
        var description: TextView = itemView.findViewById(R.id.textView9)
        var Image: ImageView = itemView.findViewById(R.id.imageView5)
        var add: ImageView = itemView.findViewById(R.id.imageView4)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shablon_burger, parent, false)
        return TypeHolder(view)
    }

    override fun onBindViewHolder(holder: TypeHolder, position: Int) {
        holder.itemView.apply {
            holder.nameOfBurger.text = list[position].name
            holder.description.text = list[position].description
            holder.price.text = list[position].cena.toString()
            holder.Image.setImageResource(list[position].imageId)
            holder.add.setImageResource(list[position].plus)
            holder.add.setOnClickListener {
//                if (!temp){
//                    temp = true
////                    holder.add.setImageResource(R.drawable.add_circle2)
//                    clickListener.fonItemClick(position)
//                }else if (temp){
//                    temp = false
//                    holder.add.setImageResource(R.drawable.add_circle)
                clickListener.fonItemClick(position)
            }

        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    interface PlusClickListener {
        fun fonItemClick(position: Int)
    }

}