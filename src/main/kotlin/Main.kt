package com.braiso_22

import com.braiso_22.mensamientos.mensamiento
import com.braiso_22.mensamientos.randomMensamiento
import dev.kord.common.entity.PresenceStatus
import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import dev.kord.gateway.builder.PresenceBuilder

suspend fun main() {
    val kord = Kord("")
    kord.saludation()
    kord.help()
    kord.randomMensamiento()
    kord.mensamiento()

    kord.login {
        // we need to specify this to receive the content of messages
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent

        // esto es para enseñar una luna y el juego en el estado
        presence = PresenceBuilder().apply {
            status = PresenceStatus.Idle
            playing("CSS: find the purple 1px border")
        }.toPresence()
    }
}