package com.architecture.usercenter.service.impl

import com.architecture.usercenter.data.respository.UploadRepository
import com.architecture.baselibrary.ext.convert
import com.architecture.usercenter.service.UploadService
import io.reactivex.Observable
import javax.inject.Inject

/*
    上传业务实现类
 */
class UploadServiceImpl @Inject constructor(): UploadService {

    @Inject
    lateinit var repository: UploadRepository

    override fun getUploadToken(): Observable<String> {
       return repository.getUploadToken().convert()
    }

}
