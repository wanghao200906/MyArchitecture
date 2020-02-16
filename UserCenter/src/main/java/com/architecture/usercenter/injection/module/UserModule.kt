package com.architecture.usercenter.injection.module

import com.architecture.usercenter.service.UserService
import com.architecture.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/*
    用户模块Module
 */
@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }

}

