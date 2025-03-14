package org.xima.penguinprojectkmp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.xima.penguinprojectkmp.data.remote.model.PenguinDTO
import org.xima.penguinprojectkmp.domain.model.Penguin

interface PenguinService {
    suspend fun getAllPenguins(): List<Penguin>
}

class PenguinServiceImpl(
    private val httpClient: HttpClient
) : PenguinService {
    override suspend fun getAllPenguins(): List<Penguin> {
        return try {
            val response: List<PenguinDTO> = httpClient.get("allPenguins").body()
            response.map { it.toDomain() }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}