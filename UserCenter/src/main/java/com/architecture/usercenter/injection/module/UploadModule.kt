package com.architecture.usercenter.injection.module

import com.architecture.usercenter.service.UploadService
import com.architecture.usercenter.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/*
    上传Module
 */
@Module
class UploadModule {

    @Provides
    fun provideUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }

}
