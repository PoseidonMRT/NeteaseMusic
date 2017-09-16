package com.study.neteasemusic.base.multitype

import com.study.neteasemusic.R

/**
 * Created by tuozhaobing on 17/9/16.
 */
class ImageTextRowType: BaseType {

    private var mText: String = ""
    private var mTextResourceId: Int = -1
    private var mImageResourceId: Int = -1
    private var mLinearText: String = ""

    constructor(mText: String, mImageResourceId: Int) {
        this.mText = mText
        this.mImageResourceId = mImageResourceId
    }

    constructor(mTextResourceId: Int, mImageResourceId: Int, mLinearText: String) {
        this.mTextResourceId = mTextResourceId
        this.mImageResourceId = mImageResourceId
        this.mLinearText = mLinearText
    }

    fun getTextResourceId(): Int{
        return mTextResourceId
    }

    fun setTextResourceId(text: Int){
        mTextResourceId = text
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
        return R.layout.image_text_row_type
    }
}