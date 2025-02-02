package com.braiso_22.saludation

import com.braiso_22.utils.getAllMembersOfGuild
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import kotlinx.coroutines.delay
import java.time.LocalTime
import kotlin.random.Random
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

val juanChannel = Snowflake(1308349431824912416)


fun Kord.saludation(waitTime: Duration = 29.minutes) {
    this.on<ReadyEvent> {
        kord.getChannelOf<MessageChannel>(juanChannel)?.let { channel ->

            var lastSentPeriod: SaludationState = SaludationState.None
            while (true) {
                val now = LocalTime.now()

                val currentPeriod = when (now) {
                    in LocalTime.of(6, 0)..LocalTime.of(12, 21) -> SaludationState.Morning
                    in LocalTime.of(12, 20)..LocalTime.of(16, 40) -> SaludationState.MidDay
                    in LocalTime.of(16, 41)..LocalTime.of(20, 0) -> SaludationState.Afternoon
                    else -> SaludationState.Night
                }

                if (currentPeriod != lastSentPeriod) {
                    val members = getAllMembersOfGuild()
                    val userNames = members.map { it.mention }

                    val selectedUsers = userNames.getRandomUserOrUsers()?.joinToString() ?: ""

                    val message = if (currentPeriod == SaludationState.None) {
                        null
                    } else {
                        currentPeriod.getMessage(selectedUsers)
                    }
                    message?.let {
                        channel.createMessage(it)
                    }
                    lastSentPeriod = currentPeriod
                }

                delay(waitTime)
            }
        }
    }
}


fun List<String>.getRandomUserOrUsers(): List<String>? {
    val randomNumberOfUsers = Random.nextInt(
        0, 3
    )
    if (randomNumberOfUsers == 0) {
        return null
    }
    return this.shuffled().take(randomNumberOfUsers)
}