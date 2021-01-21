package sfy.app.qiantaotoutiao.ui.main.model

import sfy.app.qiantaotoutiao.mvp.model.BaseModel

/**
 * author : sfy
 * time   : 2021/1/21
 * desc   :
 */
data class MainModel(
    val data: List<Data>,
    val stat: String
)

data class Data(
    val author_name: String,
    val category: String,
    val date: String,
    val thumbnail_pic_s: String,
    val thumbnail_pic_s02: String,
    val thumbnail_pic_s03: String,
    val title: String,
    val uniquekey: String,
    val url: String
)