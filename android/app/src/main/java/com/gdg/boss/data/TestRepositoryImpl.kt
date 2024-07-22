package com.gdg.boss.data

import com.gdg.boss.domain.Entity
import com.gdg.boss.domain.TestRepository
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val service: TestApi
): TestRepository {
    suspend fun sample(): Entity {
        return service.sample()
    }
}
