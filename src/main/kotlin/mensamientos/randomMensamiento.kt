package com.braiso_22.mensamientos

import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.time.Duration.Companion.minutes


const val waitTime = 29
fun Kord.randomMensamiento() {
    this.on<ReadyEvent> {
        val channel = kord.getChannelOf<MessageChannel>(Snowflake(1308349431824912416))
       //  delay(5.minutes)

        var lastSelectedDate = LocalDateTime.now()
        while (true) {
            if (lastSelectedDate.until(LocalDateTime.now(), ChronoUnit.MINUTES) < waitTime) {
                delay(waitTime.minutes)
                continue
            }
            channel?.createMessage(mensamientos.getRandom())
            lastSelectedDate = LocalDateTime.now()
        }
    }
}