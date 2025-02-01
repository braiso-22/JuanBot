package com.braiso_22

import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import kotlinx.coroutines.delay
import java.time.LocalTime
import kotlin.random.Random
import kotlin.time.Duration.Companion.minutes

val juanChannel = Snowflake(1308349431824912416)


fun Kord.saludation() {
    this.on<ReadyEvent> {
        kord.getChannelOf<MessageChannel>(juanChannel)?.let { channel ->
            val data = channel.data
            val users = data.recipients.value ?: emptyList()

            val userNames = users.mapNotNull {
                kord.getUser(it)?.data?.username
            }
            var lastSentPeriod: SaludationState = SaludationState.None


            while (true) {
                val selectedUsers = userNames.getRandomUserOrUsers()?.joinToString() ?: ""

                val now = LocalTime.now()

                val currentPeriod = when (now) {
                    in LocalTime.of(6, 0)..LocalTime.of(12, 21) -> SaludationState.Morning
                    in LocalTime.of(12, 20)..LocalTime.of(16, 40) -> SaludationState.MidDay
                    in LocalTime.of(16, 41)..LocalTime.of(20, 0) -> SaludationState.Afternoon
                    else -> SaludationState.Night
                }

                if (currentPeriod != lastSentPeriod) {
                    val message = when (currentPeriod) {
                        SaludationState.None -> null
                        else -> currentPeriod.message(selectedUsers)
                    }
                    message?.let {
                        channel.createMessage(it)
                    }
                    lastSentPeriod = currentPeriod
                }

                delay(29.minutes)
            }
        }
    }
}

fun List<String>.getRandomUserOrUsers(): List<String>? {
    if (this.isEmpty())
        return null

    val randomNumberOfUsers = Random.nextInt(1, this.size + 1)
    return this.map { "@$it" }.shuffled().take(randomNumberOfUsers)
}

fun saludoMorning(user: String) =
    "Hola buenos días, $user cómo estás? Cómo amaneces? Cualquier cosa que necesites ando por aquí, muchos ánimos!"

fun saludoMidDay(user: String) = "Perdona que te moleste, $user voy a comer a los codillos, ahorita te llamo"

fun saludoAfternoon(user: String) = "Boas tardes, $user ya marcho a tomar unos wiskitos"

fun saludoNight(user: String) = "Boas noites xentiña, a descansar moito!"

sealed class SaludationState(
    val message: ((String) -> String)
) {
    data object Morning : SaludationState(
        message = { saludoMorning(it) }
    )

    data object MidDay : SaludationState(
        message = { saludoMidDay(it) }
    )

    data object Afternoon : SaludationState(
        message = { saludoAfternoon(it) }
    )

    data object Night : SaludationState(
        message = { saludoNight(it) }
    )

    data object None : SaludationState(
        message = { "" }
    )
}