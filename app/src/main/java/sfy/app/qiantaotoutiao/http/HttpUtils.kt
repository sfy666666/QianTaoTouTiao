package sfy.app.qiantaotoutiao.http

import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sfy.app.qiantaotoutiao.base.Constants.BASE_URL
import sfy.app.qiantaotoutiao.base.Constants.BASE_URL_TEST
import java.util.concurrent.TimeUnit

/**
 * author : sfy
 * time   : 2021/1/20
 * desc   :
 */
object HttpUtils {
    //object里面的方法和属性全是静态的
    private var mOkHttp: OkHttpClient? = null

    //控制当前环境的方法
    private fun isTest(isTest: Boolean): String = if (isTest) BASE_URL_TEST else BASE_URL

    //创建Api
    fun <T> createApi(clazz: Class<T>): T = Retrofit.Builder()
        .baseUrl(isTest(true))
        .client(getClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加适配器
        .addConverterFactory(GsonConverterFactory.create())//添加解析工厂
        .build().create(clazz)//创建指定类型

    private fun getClient(): OkHttpClient? {
        if (mOkHttp == null) {
            mOkHttp = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())//添加拦截器
                .retryOnConnectionFailure(true)//重定向
                .readTimeout(30,TimeUnit.SECONDS)//设置超时时间
                .connectTimeout(30,TimeUnit.SECONDS)//设置重连超时时间
                .build()
        }
        return mOkHttp
    }
    private fun getInterceptor():Interceptor{
        HttpLoggingInterceptor.Logger {
            Logger.json(it)
        }
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    fun<T> sendHttp(ob:Observable<T>,listener:ResponeseListener<T>){
        ob.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<T> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: T) {
                    listener!!.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    listener!!.onFail(e.message.toString())
                }


            })
    }
}

