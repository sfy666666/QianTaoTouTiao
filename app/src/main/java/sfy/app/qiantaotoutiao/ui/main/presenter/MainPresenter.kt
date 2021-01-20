package sfy.app.qiantaotoutiao.ui.main.presenter

import sfy.app.qiantaotoutiao.mvp.presenter.BasePresenter
import sfy.app.qiantaotoutiao.ui.main.view.MainView

/**
 * author : sfy
 * time   : 2021/1/19
 * desc   :
 */
class MainPresenter: BasePresenter<MainView>() {
    fun getTest(str:String){
        getBaseView()!!.setData(str);
    }
}