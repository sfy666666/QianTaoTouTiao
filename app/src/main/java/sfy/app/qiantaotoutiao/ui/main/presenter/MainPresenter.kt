package sfy.app.qiantaotoutiao.ui.main.presenter

import sfy.app.qiantaotoutiao.http.HttpUtils
import sfy.app.qiantaotoutiao.http.ResponeseListener
import sfy.app.qiantaotoutiao.http.UserApi
import sfy.app.qiantaotoutiao.mvp.model.BaseModel
import sfy.app.qiantaotoutiao.mvp.presenter.BasePresenter
import sfy.app.qiantaotoutiao.ui.main.model.MainModel
import sfy.app.qiantaotoutiao.ui.main.view.MainView

/**
 * author : sfy
 * time   : 2021/1/19
 * desc   :
 */
class MainPresenter: BasePresenter<MainView>() {
    fun getTest(str:String){
        getBaseView()!!.setData(str)
    }
    fun getTest(){
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(),object :ResponeseListener<BaseModel<MainModel>>{
            override fun onSuccess(data: BaseModel<MainModel>) {
                if(data!=null){
                    getBaseView()!!.setData(data)
                }
            }

            override fun onFail(err: String) {
                getBaseView()!!.setError(err)
            }
        })
    }
}