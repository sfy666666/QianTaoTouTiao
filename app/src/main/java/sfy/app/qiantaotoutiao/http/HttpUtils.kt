package sfy.app.qiantaotoutiao.http

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sfy.app.qiantaotoutiao.base.Constants.BASE_URL
import sfy.app.qiantaotoutiao.base.Constants.BASE_URL_TEST

/**
 * author : sfy
 * time   : 2021/1/20
 * desc   :
 */
object HttpUtils {//object里面的方法和属性全是静态的
    //控制当前环境的方法
     private fun isTest(isTest:Boolean):String=if(isTest)BASE_URL_TEST else BASE_URL

    //创建Api
    fun <T> createApi(clazz:Class<T>):T=Retrofit.Builder()
        .baseUrl(isTest(true))
        .client()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加适配器
        .addConverterFactory(GsonConverterFactory.create())//添加解析工厂
        .build().create(clazz)//创建指定类型
}