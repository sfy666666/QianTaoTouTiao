package sfy.app.qiantaotoutiao.view

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * author : sfy
 * time   : 2021/2/1
 * desc   : 禁止滑动的ViewPager
 */
class ScrollNotViewPager : ViewPager {


    private var isDisableScroll = true//是否禁用水平滑动

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    //设置是否禁用水平滑动
    fun setDisableScroll(isDisableScroll: Boolean) {
        this.isDisableScroll = isDisableScroll
    }

    //拦截方法
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return if (isDisableScroll) {
            false
        } else {
            super.onInterceptTouchEvent(ev)
        }
    }

    /**
     * 是否消费事件
     * 消费:事件就结束
     * 不消费:往父控件传
     */
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (isDisableScroll) {
            false
        } else {
            super.onTouchEvent(ev)
        }
    }


}