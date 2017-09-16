package com.study.neteasemusic.base.multitype

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.study.neteasemusic.R
import android.widget.TextView



/**
 * Created by tuozhaobing on 17/9/16.
 */
class MultiTypesAdapter: RecyclerView.Adapter<BaseViewHolder>() {

    private lateinit var mTypes:List<BaseType>
    private var mCurrentPosition = -1

    fun setTypes(types: List<BaseType>){
        mTypes = types
    }

    override fun getItemCount(): Int {
        return mTypes.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) :BaseViewHolder{
        mCurrentPosition++
        var view = LayoutInflater.from(parent!!.context).inflate(mTypes[mCurrentPosition].getItemType(), parent, false)
        when(mTypes[mCurrentPosition].getItemType()){
            R.layout.image_text_row_type -> {
                return ImageTextViewHolder(view)
            }
            R.layout.image_text_linear_row_type -> {
                return ImageTextLinearViewHolder(view)
            }
        }
        return BaseViewHolder(view)
    }

}