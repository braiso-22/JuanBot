package com.braiso_22.mensamientos

import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import kotlin.random.Random

fun Kord.mensamientoCommand(mensamientos: List<String>) {
    this.on<MessageCreateEvent> { // runs every time a message is created that our bot can read
        // ignore other bots, even ourselves. We only serve humans here!
        if (message.author?.isBot != false) return@on

        // check if our command is being invoked
        if (!message.content.contains("!mensamiento")) return@on

        // all clear, give them the pong!
        val allMensamientos = (mensamientos).shuffled()
        message.channel.createMessage(allMensamientos.getRandom())
    }
}

fun List<String>.getRandom(): String {
    val index = Random.nextInt(this.size)
    return this[index]
}



