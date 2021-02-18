package sfy.app.qiantaotoutiao.ui.main.frg

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_my.*
import sfy.app.qiantaotoutiao.R
import sfy.app.qiantaotoutiao.ui.main.act.ui.register.RegisterActivity

/**
 * author : sfy
 * time   : 2021/1/28
 * desc   :我的
 */
class MyFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_my,container,false)
    }

    override fun onStart() {
        super.onStart()
        textView.setOnClickListener {
            val intent= Intent(activity,RegisterActivity::class.java)
            activity?.startActivity(intent)
        }
    }


}