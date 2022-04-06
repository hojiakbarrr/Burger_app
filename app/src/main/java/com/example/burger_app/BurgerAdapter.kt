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
    var ee : Int = R.drawable.text
    var aa : Int = R.drawable.peresvet

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
//            holder.itemView.drawingTime.times(12)/////*/*/**/*/*    не доделал а именно при нажатии меняется картинка но не менчется в обратную сторону
////            if (temp == true) {            h
//            holder.tvImage.setImageResource(R.drawable.text)
//            holder.tvImage.setImageResource(R.drawable.peresvet)
//            if (holder.itemView.id == 0){
//                holder.tvImage.setImageResource(R.drawable.peresvet)
//                if (holder.itemView.id == 1 && holder.itemView.id == 2 && holder.itemView.id ==3 && holder.itemView.id == 4 && holder.itemView.id == 5){
//                    holder.tvImage.setImageResource(R.drawable.text)
//                }
//            }else if (holder.itemView.id == 1){
//                holder.tvImage.setImageResource(R.drawable.peresvet)
//                if (holder.itemView.id == 0 && holder.itemView.id == 2 && holder.itemView.id ==3 && holder.itemView.id == 4 && holder.itemView.id == 5){
//                    holder.tvImage.setImageResource(R.drawable.text)
//                }
//            }else if (holder.itemView.id == 2){
//                holder.tvImage.setImageResource(R.drawable.peresvet)
//                if (holder.itemView.id == 1 && holder.itemView.id == 0 && holder.itemView.id ==3 && holder.itemView.id == 4 && holder.itemView.id == 5){
//                    holder.tvImage.setImageResource(R.drawable.text)
//                }
//            }else if (holder.itemView.id == 3){
//                holder.tvImage.setImageResource(R.drawable.peresvet)
//                if (holder.itemView.id == 1 && holder.itemView.id == 0 && holder.itemView.id ==2 && holder.itemView.id == 4 && holder.itemView.id == 5){
//                    holder.tvImage.setImageResource(R.drawable.text)
//                }
//            }else if (holder.itemView.id == 4){
//                holder.tvImage.setImageResource(R.drawable.peresvet)
//                if (holder.itemView.id == 1 && holder.itemView.id == 0 && holder.itemView.id ==2 && holder.itemView.id == 3 && holder.itemView.id == 5){
//                    holder.tvImage.setImageResource(R.drawable.text)
//                }
//            }else if (holder.itemView.id == 5){
//                holder.tvImage.setImageResource(R.drawable.peresvet)
//                if (holder.itemView.id == 1 && holder.itemView.id == 0 && holder.itemView.id ==2 && holder.itemView.id == 3 && holder.itemView.id == 4){
//                    holder.tvImage.setImageResource(R.drawable.text)
//                }
//            }

            if (temp){
                holder.tvImage.setImageResource(aa)
                temp = false
            }else{
                holder.tvImage.setImageResource(ee)
                temp = true
            }

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