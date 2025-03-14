package org.xima.penguinprojectkmp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.xima.penguinprojectkmp.domain.model.Penguin

@Serializable
data class PenguinDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("imageUrl")
    val imageUrl: String
) {
    fun toDomain(): Penguin {
        return Penguin(
            id = id,
            name = name,
            description = description,
            imageUrl = imageUrl
        )
    }
}


