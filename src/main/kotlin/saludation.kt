package com.braiso_22

import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import kotlin.time.Duration.Companion.seconds

fun Kord.saludation() {
    this.on<ReadyEvent> {
        val channel = kord.getChannelOf<MessageChannel>(Snowflake(1308349431824912416))

        val now = LocalDateTime.now()

        while (true) {
            channel?.createMessage("Hola buenos días cómo estás? Cómo amaneces? Cualquier cosa que necesites ando por aquí, muchos ánimos!")
            val nextTime = now.withHour(8).withMinute(0).withSecond(0).plusDays(1)
            val secondsToWait = java.time.Duration.between(now, nextTime).toSeconds()
            delay(secondsToWait.seconds)
        }
    }
}