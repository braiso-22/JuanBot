package com.braiso_22.saludation

sealed class SaludationState(
    val getMessage: ((String) -> String)
) {
    data object Morning : SaludationState(
        getMessage = { saludoMorning(it) }
    )

    data object MidDay : SaludationState(
        getMessage = { saludoMidDay(it) }
    )

    data object Afternoon : SaludationState(
        getMessage = { saludoAfternoon(it) }
    )

    data object Night : SaludationState(
        getMessage = { saludoNight(it) }
    )

    data object None : SaludationState(
        getMessage = { "" }
    )
}

fun saludoMorning(user: String) =
    "Hola buenos días, $user cómo estás? Cómo amaneces? Cualquier cosa que necesites ando por aquí, muchos ánimos!"

fun saludoMidDay(user: String) = "Perdona que te moleste, $user voy a comer a los codillos, ahorita te llamo"

fun saludoAfternoon(user: String) = "Boas tardes, $user ya marcho a tomar unos wiskitos"

fun saludoNight(user: String) = "Boas noites xentiña, a descansar moito!"
