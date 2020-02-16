package com.architecture.usercenter.service

import io.reactivex.Observable


/*
    上传业务接口
 */
interface UploadService {

    fun getUploadToken(): Observable<String>

}
