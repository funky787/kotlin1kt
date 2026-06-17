package org.sadovodBase

fun main() {
    print("Имя: ")
    val nameInput = readLine()?.trim().orEmpty()

    print("Возраст: ")
    val ageInput = readLine()?.trim()
    val age: Int? = if (ageInput.isNullOrEmpty()) null else ageInput.toIntOrNull()

    print("Город: ")
    val cityInput = readLine()?.trim()
    val city = cityInput?.takeIf { it.isNotEmpty() } ?: "не указан"

    val name = nameInput.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase() else it.toString()
    }

    val status = when {
        age == null -> "недостаточно данных"
        age < 18 -> "несовершеннолетний"
        age in 18..60 -> "взрослый пользователь"
        else -> "пожилой пользователь"
    }

    val report = """
        Профиль пользователя:
        Имя: $name
        Возраст: ${age ?: "не указан"}
        Город: $city
        
        Статус: $status
    """.trimIndent()

    println(report)
}