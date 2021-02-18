package sfy.app.qiantaotoutiao.ui.main.frg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sfy.app.qiantaotoutiao.R

/**
 * author : sfy
 * time   : 2021/1/28
 * desc   : 短视频
 */
class MiniVideoFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mini_video,container,false)
    }
}