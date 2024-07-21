package com.gdg.boss.data

import com.gdg.boss.domain.Entity
import retrofit2.http.*

interface TestApi {
    @GET("/test")
    suspend fun sample(): Entity
}
