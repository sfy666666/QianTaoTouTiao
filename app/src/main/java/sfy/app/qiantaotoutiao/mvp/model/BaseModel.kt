package sfy.app.qiantaotoutiao.mvp.model

/**
 * author : sfy
 * time   : 2021/1/19
 * desc   :
 */
data class BaseModel<T>(val code:Int,val message:String,val data :T) {
}