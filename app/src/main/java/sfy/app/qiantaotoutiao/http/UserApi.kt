package sfy.app.qiantaotoutiao.http

import io.reactivex.Observable
import retrofit2.http.GET
import sfy.app.qiantaotoutiao.mvp.model.BaseModel
import sfy.app.qiantaotoutiao.ui.main.model.MainModel

/**
 * author : sfy
 * time   : 2021/1/21
 * desc   :
 */
interface UserApi {
    @GET("index?type=top&key=2c1cb93f8c7430a754bc3ad62e0fac06")
    fun getTest(): Observable<BaseModel<MainModel>>
}