package org.xima.penguinprojectkmp.domain.repository

import org.xima.penguinprojectkmp.domain.model.Penguin

interface PenguinRepository {
    suspend fun getAllPenguins(): List<Penguin>
}