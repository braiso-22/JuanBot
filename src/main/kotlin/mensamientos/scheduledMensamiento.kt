package com.braiso_22.mensamientos

import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes


fun Kord.scheduledMensamiento(mensamientos: List<String>, waitTime: Duration = 29.minutes) {
    this.on<ReadyEvent> {
        val channel = kord.getChannelOf<MessageChannel>(Snowflake(1308349431824912416))

        var lastSelectedDate = LocalDateTime.now()
        while (true) {
            if (lastSelectedDate.until(LocalDateTime.now(), ChronoUnit.MINUTES) < waitTime.inWholeMinutes) {
                delay(waitTime)
                continue
            }
            channel?.createMessage(mensamientos.getRandom())
            lastSelectedDate = LocalDateTime.now()
        }
    }
}