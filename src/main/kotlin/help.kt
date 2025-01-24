package com.braiso_22

import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on

fun Kord.help() {
    this.on<MessageCreateEvent> { // runs every time a message is created that our bot can read
        // ignore other bots, even ourselves. We only serve humans here!
        if (message.author?.isBot != false) return@on

        // check if our command is being invoked
        if (message.content != "!help") return@on

        // all clear, give them the pong!
        message.channel.createMessage(
            """Los comandinhos son estos:
            |```
            |!mensamiento
            |!help
            |```
            |☺️""".trimMargin()

        )
    }
}