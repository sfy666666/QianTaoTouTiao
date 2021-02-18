package sfy.app.qiantaotoutiao.ui.main.act.ui.register

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import sfy.app.qiantaotoutiao.R
import sfy.app.qiantaotoutiao.base.BaseActivity
import sfy.app.qiantaotoutiao.ui.main.presenter.MainPresenter
import sfy.app.qiantaotoutiao.ui.main.view.MainView


class RegisterActivity : BaseActivity<MainView,MainPresenter>(),MainView {
    override fun getLayoutId(): Int= R.layout.activity_register

    override fun initData() {
        imageBack.setOnClickListener{
            finish()
        }
        val pattern="^0?(13|14|15|17|18|16|19|12|10)\\d{9}\$".toRegex()


        nextStep.setOnClickListener {
            if(!agreement.isChecked){
                Toast.makeText(this,"同意用户协议和隐私政策后才可以注册", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(!pattern.matches(input.editableText.toString().trim())){
                Toast.makeText(this,"手机号格式错误", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"注册成功", Toast.LENGTH_SHORT).show()
            }
        }



    }

    override fun init() {
    }

    override fun createPresenter()= MainPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }


}
