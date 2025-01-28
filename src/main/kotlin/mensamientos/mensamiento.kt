package com.braiso_22.mensamientos

import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import kotlin.random.Random

fun Kord.mensamiento(){
    this.on<MessageCreateEvent> { // runs every time a message is created that our bot can read
        // ignore other bots, even ourselves. We only serve humans here!
        if (message.author?.isBot != false) return@on

        // check if our command is being invoked
        if (!message.content.contains("!mensamiento")) return@on

        // all clear, give them the pong!
        message.channel.createMessage(mensamientos.getRandom())
    }
}

fun List<String>.getRandom(): String {
    val index = Random.nextInt(this.size)
    return this[index]
}

val mensamientos = listOf(
    "ahorita voy",
    "Ya va",
    "Mil perdones🙏🏾",
    "Bien con alergia, pero ahí vamos jejejej",
    "Eu non sei nada, son un niño pequeño😏",
    "Patatillas del amoooor❤️",
    "voy coller uns chasqui😋",
    "Pero aún te amooo y vivo enamoradooo 🎶",
    "En hora boa",
    "Yo mensaba...",
    "Error de diseño!",
    "Hay que facer las cosaas como tal...",
    "Sii, lo mismo que esta dicendo moita xentee",
    "border 1px solid purple;",
    "? non entender sorry \uD83D\uDE42",
    "Xudiit canta que tú cantas muy bonito",
    "No te preocupes, tú eres moi intelixente",
    "Súper cool.\uD83D\uDC4D",
    "issue design",
    "jejejeje",
    "Estoy caliente",
    "Me la estás poniendo dura(la vida)",
    "Se está poniendo dura😩",
    "Eu te amo, de verdade!",
    "Relax se come mas rico comidita en casa",
    "sorry esataba tomando cafe",
    "me da medo jejeje",
    "Aún no hay responsa a iso",
    "jejejej hoy estamos de mièrcoles",
    "yo de eso no lo se soy un santiño",
    "amo la nutella",
    "El platano macho me da arcada",
    "You are an angel",
    "No puedo, tengo clase de danza",
    "Pero como mañana o viernes estoy perdido! \uD83D\uDE4F \uD83D\uDE05",
    "que es el fernando Alfonzo?",
    "Vos sabedes donde está el Sr. Iago?",
    "Maravilloso eso \uD83D\uDE0A",
    "Ya comí \uD83D\uDE0A \n",
    "Corregido canto tenho que poñer na ucha ?",
    "flex jejejejejeje que es iso jejejeje jejejej de css jejeje",
    "yo quiero facer arepa con iso \uD83D\uDE26\n",
    "Me parto jejejejee",
    "Noon hoxe non. Como afuera",
    "Sois malos jejejeej",
    "Uy si, yo en un rato salgo a comer ☺\uFE0F",
    "Tengo miedo non sei jjejeejjejejejeej",
    "Pero  mañán viene el Sr. Michi ☺\uD83D\uDE25.",
    "cómo asi no entender jejejejejejee",
    "Hola equipo disculpen que les interrumpa",
    "Tranqui @Cwellt-Noelia pago o euro por ella ya está por una vez no pasa nada. si sois jejejeje",
    "Què està sucedindo al`jejejeç",
    "Noo, muy tise \uD83D\uDE26",
    "Maravilloso, lo coloco igual en mis documentos ☺",
    "Meu Deush qué es eso jeje",
    "Oh meu Desuh \uD83D\uDE0A",
    "no hablo Ruso",
    "haiga",
    "imprimido",
    "jejejejeej soy de diseño non entender jejeje",
    "Perdona mil disculpas non sei que es , busco por internet",
    "la forma de cantar que lindo ahorita lo veo",
    "Claro trabajo pero relax ropa comoda",
    "de realex , de desconection jejejejeje",
    "No me gusat el latigo es muy  doloroso \n",
    "De minha parte no tengo inconveniente",
    "Que rico suena ☺\uFE0F",
    "Uy no  estaré como un toro no jejejejee amo el coffee pero tanto asi de una non podo jejeje",
    "es tipico muchas prsonas han pasado por eso como el exorcismo",
    "Que rico Nunca lo he probado. Sabe rico? \uD83E\uDD73",
    "Que lindo el churro dentro de la dona moviendose que bonito  \uD83D\uDE0A",
    "Feliz cumple Siuuuuuuuuuu",
    "hay gente que le gusta la nuetlla con la banana",
    "La verdad nunca siempre he sido muy precavido jejejeje",
    "bueh tranqui cosas que pasan , suele sueceder",
    "jejejejeje siuuuuuuuuuuuuuuuuuuuuu",
    "No entendi que hay  ahi, comida? se come rico?",
    "Tranqui miña xente sin pelear , con calma , peace and Love \uD83D\uDE0A ❤\uFE0F",
    "con calmaa",
    "I don't understand \uD83D\uDE0A",
    "por amor a cristo \uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02",
    "Maldad pura jejejejej\uD83D\uDE05",
    "I love it \uD83D\uDE0A",
    "Srta. Judit Lustres  de los Ángeles",
    "Metes y sacas, metes y sacas",
    "Disculpa, que te agarré el coso así...",
    "Disculpa que abuse de tu confianza",
    "perdona que te agarré el mouse así sin permiso'",
    "la leche de cúrcuma  es muy rica",
    "las manos las tengo que usar",
    "Te agarro la bola Alex?",
    "Cuando corro, corro mucho, me fascina",
    "Cuando corro, corro mucho, me fascina\nHay corridas que te cansan",
    "Hay corridas que te cansan",
    "Judit quiere que le agarre el mouse",
    "me estaba sacudiendo la nariz porque me comí una pera",
    "Yo se que vas a atacar mis pezones",
    "bolas grandes, siempre",
    "me gusta el platano con huevo",
    "Yo la meto entera",
    "Me dijo Noelia que la meta",
    "ataque contra negrito",
    "sabes que puedes tocar todo lo que quieras",
    "Fuera demoniooo",
    "Hay que meter la banana en el congelador para que se ponga dura",

    "No sabpia, nunca la he probado con Nutella, con pan si \uD83D\uDE0A \uD83D\uDE05",
    "```css\nclassName={\n\tisActive_fitler_item_all ? ...\n}\n```"
)
