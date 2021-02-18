package sfy.app.qiantaotoutiao.utils

import android.app.Activity
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.view.View
import androidx.core.content.ContextCompat
import sfy.app.qiantaotoutiao.base.Constants.HOME_BAR

/**
 * author : sfy
 * time   : 2021/2/18
 * desc   :
 */
object StatusBarUtils {
    fun setStatusBar(activity: Activity,barType:Int,colorIds:Int){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            //设置首页和其他页面的bar样式
            if(barType==HOME_BAR){
                activity.window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }else{
                activity.window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            //设置颜色
            activity.window.statusBarColor=ContextCompat.getColor(activity,colorIds)
        }
    }
}