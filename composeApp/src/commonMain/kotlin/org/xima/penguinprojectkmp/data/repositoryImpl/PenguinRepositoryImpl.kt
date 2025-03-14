package org.xima.penguinprojectkmp.data.repositoryImpl

import org.xima.penguinprojectkmp.data.remote.PenguinService
import org.xima.penguinprojectkmp.domain.model.Penguin
import org.xima.penguinprojectkmp.domain.repository.PenguinRepository

class PenguinRepositoryImpl(
    private val penguinService: PenguinService
) : PenguinRepository {
    override suspend fun getAllPenguins(): List<Penguin> {
        return penguinService.getAllPenguins()
    }
}