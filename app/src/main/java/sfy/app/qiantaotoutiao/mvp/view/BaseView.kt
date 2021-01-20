package sfy.app.qiantaotoutiao.mvp.view

/**
 * author : sfy
 * time   : 2021/1/19
 * desc   :
 */
interface BaseView {
    fun<T> setData(data:T)
    fun setError(err:String)
}