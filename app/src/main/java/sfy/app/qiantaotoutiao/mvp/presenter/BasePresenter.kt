package sfy.app.qiantaotoutiao.mvp.presenter

/**
 * author : sfy
 * time   : 2021/1/19
 * desc   :
 */
 open class BasePresenter <V>{
    private  var mBaseView:V?=null
    fun bindView(mBaseView:V){
        this.mBaseView=mBaseView
    }
    fun unBindView(){
        this.mBaseView=null
    }
    fun getBaseView()=mBaseView
}