package sfy.app.qiantaotoutiao.ui.main.act

import android.content.res.TypedArray
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*
import sfy.app.qiantaotoutiao.R
import sfy.app.qiantaotoutiao.base.BaseActivity
import sfy.app.qiantaotoutiao.base.Constants.HOME_BAR
import sfy.app.qiantaotoutiao.ui.main.adapter.HomeAdapter
import sfy.app.qiantaotoutiao.ui.main.frg.HomeFragment
import sfy.app.qiantaotoutiao.ui.main.frg.MiniVideoFragment
import sfy.app.qiantaotoutiao.ui.main.frg.MyFragment
import sfy.app.qiantaotoutiao.ui.main.frg.VideoFragment
import sfy.app.qiantaotoutiao.ui.main.model.TitleModel
import sfy.app.qiantaotoutiao.ui.main.presenter.MainPresenter
import sfy.app.qiantaotoutiao.ui.main.view.MainView
import sfy.app.qiantaotoutiao.utils.StatusBarUtils

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
        //设置状态栏颜色
        StatusBarUtils.setStatusBar(this,HOME_BAR,R.color.c_E6645F)
        val titles: Array<String> = resources.getStringArray(R.array.title)
        val selectIds: TypedArray = resources.obtainTypedArray(R.array.selected)
        val unSelectIds: TypedArray = resources.obtainTypedArray(R.array.unselected)
        fragments.add(HomeFragment())
        fragments.add(VideoFragment())
        fragments.add(MiniVideoFragment())
        fragments.add(MyFragment())
        //遍历title 拼接tabs
        for (i: Int in titles.indices) {
            titleTabs.add(
                TitleModel(
                    titles[i],
                    unSelectIds.getResourceId(i, 0),
                    selectIds.getResourceId(i, 0)
                )
            )
        }
        //viewPage添加适配器
        vp_home.adapter = HomeAdapter(supportFragmentManager, fragments)
        vp_home.offscreenPageLimit = fragments.size
        vp_home.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
            }

        })
        ctl_home.setTabData(titleTabs)
        ctl_home.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                vp_home.setCurrentItem(
                    position,
                    false
                )//smoothScroll控制ViewPager动画，false关闭后ViewPager不会闪烁
            }

            override fun onTabReselect(position: Int) {
            }

        })
    }

    override fun init() {


    }

    override fun createPresenter() = MainPresenter();

    override fun <T> setData(data: T) {
        Log.i("test", "===============>$data")
    }

    override fun setError(err: String) {
    }
}