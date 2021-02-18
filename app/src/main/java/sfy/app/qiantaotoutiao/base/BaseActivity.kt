package sfy.app.qiantaotoutiao.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sfy.app.qiantaotoutiao.R
import sfy.app.qiantaotoutiao.base.Constants.COMMON_BAR
import sfy.app.qiantaotoutiao.mvp.presenter.BasePresenter
import sfy.app.qiantaotoutiao.mvp.view.BaseView
import sfy.app.qiantaotoutiao.utils.StatusBarUtils

abstract class BaseActivity<V,P: BasePresenter<V>> : AppCompatActivity() , BaseView {
    private var mPresenter:P?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        //设置统一的状态栏颜色
        StatusBarUtils.setStatusBar(this, COMMON_BAR, R.color.c_ffffff)
        if(mPresenter==null){
            mPresenter=createPresenter() as P
        }
        mPresenter!!.bindView(this as V)
        init()
        initData()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initData()

    protected abstract fun init()

    protected abstract  fun createPresenter():P

    fun getPresenter()=mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }
}