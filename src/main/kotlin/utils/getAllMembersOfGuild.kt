package com.braiso_22.utils


import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.Member

val juanBot = Snowflake(1332112342917447762)

suspend fun Kord.getAllMembersOfGuild(guild: Snowflake = Snowflake(1237732287265636372)): List<Member> {
    val server = guild
    val discordUsers = this.rest.guild.getGuildMembers(server, limit = 100)
    val members = discordUsers.mapNotNull {
        it.user.value
    }.filter { it.id != juanBot }.map {
        this.getGuild(server).getMember(it.id)
    }

    return members
}