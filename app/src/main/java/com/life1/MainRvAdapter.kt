package com.life1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRvAdapter(val context: Context, val list: ArrayList<Model>) :
    RecyclerView.Adapter<MainRvAdapter.Holder>() {

    var itemClick: ItemClick? = null

    /** recyclerview kotlin onitemclick 구글 검색해서 아이템 하나하나에 들어가는거 해주기**/
    interface ItemClick{
        fun onClick(view: View, position: Int)
    }


    /** 상위 레이아웃에 넣을 하위 레이아웃을 생성하기**/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvAdapter.Holder {

        val view = LayoutInflater.from(context).inflate(R.layout.main_rv_item, parent, false)
        return Holder(view)
    }

    /** view에 데이터를 하나씩 넣어주는 코드 **/
    override fun onBindViewHolder(holder: MainRvAdapter.Holder, position: Int) {
        if(itemClick != null){
            holder?.itemView?.setOnClickListener{ v->
                itemClick?.onClick(v, position)
            }
        }
        holder.bind(list[position], context)
    }

    /**view의 개수를 리턴**/
    override fun getItemCount(): Int {
        return list.size
    }

    /** **/
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo = itemView?.findViewById<ImageView>(R.id.image_area)
        val title = itemView?.findViewById<TextView>(R.id.text_area)

        fun bind(model: Model, context: Context) {
            title.text = model.title
        }
    }
}