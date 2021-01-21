package sfy.app.qiantaotoutiao.http

/**
 * author : sfy
 * time   : 2021/1/21
 * desc   :
 */
interface ResponeseListener<T> {
    fun onSuccess(data:T)
    fun onFail(err:String)
}