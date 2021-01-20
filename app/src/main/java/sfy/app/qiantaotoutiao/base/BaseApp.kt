package sfy.app.qiantaotoutiao.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * author : sfy
 * time   : 2021/1/19
 * desc   :
 */
class BaseApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())

    }
}