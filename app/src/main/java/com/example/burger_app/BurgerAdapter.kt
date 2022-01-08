package com.example.burger_app

import android.graphics.Color
import android.graphics.PixelFormat.TRANSPARENT
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.translationMatrix
import androidx.recyclerview.widget.RecyclerView
import android.content.Context as Context1

class BurgerAdapter(
    val list: ArrayList<Burger>,
    val clickListener: FoodClickListener,
    val context: Context1,
) : RecyclerView.Adapter<BurgerAdapter.BurgerHolder>() {
    var temp: Boolean = true

    inner class BurgerHolder(item: View) : RecyclerView.ViewHolder(item) {
        var tvItemUser: TextView = itemView.findViewById(R.id.textView5)
        var tvImage: ImageView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shablon_icon, parent, false)
        return BurgerHolder(view)
    }

    override fun onBindViewHolder(holder: BurgerHolder, position: Int) {
        holder.itemView.apply {
            holder.tvItemUser.text = list[position].title
        }
        holder.itemView.setOnClickListener {
            holder.itemView.drawingTime.times(12)/////*/*/**/*/*    не доделал а именно при нажатии меняется картинка но не менчется в обратную сторону
//            if (temp == true) {            h
            holder.tvImage.setImageResource(R.drawable.text)
            holder.tvImage.setImageResource(R.drawable.peresvet)

            clickListener.onItemClick(position)
//                temp = false
//            }else if (temp == false){
//                clickListener.onItemClick(position)
//                temp = true
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }


    interface FoodClickListener {
        fun onItemClick(position: Int)
    }

}