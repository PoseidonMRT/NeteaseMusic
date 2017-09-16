package com.study.neteasemusic.base.multitype

import com.study.neteasemusic.R

/**
 * Created by tuozhaobing on 17/9/16.
 */
class ImageTextLinearRowType: BaseType {

    private var mText: String = ""
    private var mImageResourceId: Int = -1
    private var mLinearText: String = ""

    constructor(mText: String, mImageResourceId: Int) {
        this.mText = mText
        this.mImageResourceId = mImageResourceId
    }

    constructor(mText: String, mImageResourceId: Int, mLinearText: String) {
        this.mText = mText
        this.mImageResourceId = mImageResourceId
        this.mLinearText = mLinearText
    }

    fun getLinearText(): String {
        return mLinearText
    }

    fun setLinearText(text: String){
        mLinearText = text
    }

    fun getText(): String {
        return mText
    }

    fun setText(text: String) {
        mText = text
    }

    fun setImageResourceId(resourceId: Int){
        mImageResourceId = resourceId
    }

    fun getImageResourceId(): Int{
        return mImageResourceId
    }

    override fun getItemType(): Int {
        return R.layout.image_text_linear_row_type
    }
}