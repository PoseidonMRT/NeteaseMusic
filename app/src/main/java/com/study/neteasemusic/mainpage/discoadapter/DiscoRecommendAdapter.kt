package com.study.neteasemusic.mainpage.discoadapter

import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


/**
 * Created by tuozhaobing on 17/9/6.
 */
class DiscoRecommendAdapter(var mContext: Context,var mTypes:List<Int>):  RecyclerView.Adapter<DiscoRecommendAdapter.DashboardItemHolder>(){

    override fun onBindViewHolder(holder: DashboardItemHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DashboardItemHolder {
        return DashboardItemHolder(LayoutInflater.from(parent!!.context).inflate(viewType,parent,false))
    }

    class DashboardItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView
        val title: TextView
        val summary: TextView

        init {
            icon = itemView.findViewById(android.R.id.icon) as ImageView
            title = itemView.findViewById(android.R.id.title) as TextView
            summary = itemView.findViewById(android.R.id.summary) as TextView
        }
    }
}