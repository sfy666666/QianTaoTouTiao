package sfy.app.qiantaotoutiao.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * author : sfy
 * time   : 2021/1/27
 * desc   : title数据模型
 */
data class TitleModel(val title: String, val select: Int, val unSelect: Int) : CustomTabEntity {
    override fun getTabUnselectedIcon(): Int =unSelect
    override fun getTabSelectedIcon(): Int=select
    override fun getTabTitle(): String =title
}