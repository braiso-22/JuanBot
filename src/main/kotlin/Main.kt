package com.braiso_22

import com.braiso_22.mensamientos.mensamientoCommand
import com.braiso_22.mensamientos.scheduledMensamiento
import com.braiso_22.mensamientos.strings.fakeMensamientos
import com.braiso_22.mensamientos.strings.mensamientos
import com.braiso_22.saludation.saludation
import dev.kord.common.entity.PresenceStatus
import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import dev.kord.gateway.builder.PresenceBuilder

suspend fun main() {

    val kord = Kord("")
    kord.saludation()
    kord.help()
    val allMensamientos = (mensamientos+ fakeMensamientos).shuffled()
    kord.scheduledMensamiento(allMensamientos)
    kord.mensamientoCommand(allMensamientos)

    kord.login {
        // we need to specify this to receive the content of messages
        @OptIn(PrivilegedIntent::class)
        intents += Intents(Intent.GuildMembers, Intent.MessageContent)

        // esto es para enseñar una luna y el juego en el estado
        presence = PresenceBuilder().apply {
            status = PresenceStatus.Idle
            playing("CSS: find the purple 1px border")
        }.toPresence()
    }
}