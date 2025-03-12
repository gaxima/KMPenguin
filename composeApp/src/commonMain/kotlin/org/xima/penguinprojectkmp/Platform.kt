package org.xima.penguinprojectkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform