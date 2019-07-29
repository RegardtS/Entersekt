package com.regi.cityslickersdk.repo

import com.regi.cityslickersdk.service.MockyService

object MockyRepositoryProvider {
    fun providePicRepository() : MockyRepository{
        return MockyRepository(MockyService.create())
    }
}