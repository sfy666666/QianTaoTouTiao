package sfy.app.qiantaotoutiao.ui.main.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import sfy.app.qiantaotoutiao.R
import sfy.app.qiantaotoutiao.base.BaseActivity
import sfy.app.qiantaotoutiao.ui.main.presenter.MainPresenter
import sfy.app.qiantaotoutiao.ui.main.view.MainView

class MainActivity : BaseActivity<MainView,MainPresenter>(),MainView {


    override fun getLayoutId(): Int =R.layout.activity_main

    override fun initData() {
    }

    override fun init() {
        btn_test.setOnClickListener {
            getPresenter()!!.getTest("test")
            getPresenter()!!.getTest()
        }
    }

    override fun createPresenter() =MainPresenter();

    override fun <T> setData(data: T) {
        Log.i("test","===============>$data")
    }

    override fun setError(err: String) {
    }
}