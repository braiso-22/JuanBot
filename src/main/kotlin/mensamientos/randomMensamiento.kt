package com.braiso_22.mensamientos

import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.Duration.Companion.minutes

fun Kord.randomMensamiento() {
    this.on<ReadyEvent> {
        val channel = kord.getChannelOf<MessageChannel>(Snowflake(1308349431824912416))
        delay(5.minutes)
        while (true) {
            channel?.createMessage(mensamientos.getRandom())

            val minutesList = (20..70).toList()
            val index = Random.nextInt(minutesList.size)

            delay(minutesList[index].minutes)
        }
    }
}