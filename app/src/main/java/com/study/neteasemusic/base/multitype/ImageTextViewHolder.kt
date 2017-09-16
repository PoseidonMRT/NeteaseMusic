package com.study.neteasemusic.base.multitype

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.study.neteasemusic.R

/**
 * Created by tuozhaobing on 17/9/16.
 */
class ImageTextViewHolder: BaseViewHolder {
    private lateinit var mTextView: TextView
    private lateinit var mImageView: ImageView
    constructor(itemView: View?) : super(itemView){
        mTextView = itemView!!.findViewById(R.id.item_text) as TextView
        mImageView = itemView!!.findViewById(R.id.item_image) as ImageView
    }
}