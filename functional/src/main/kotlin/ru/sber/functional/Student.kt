package ru.sber.functional

data class Student(
    val firstName: String,
    val lastName: String,
    val middleName: String = "Отсутствует",
    val age: Int = 0,
    val averageRate: Double,
    val city: String = "",
    val specialization: String = "Отсутствует",
    val prevEducation: String? = "Отсутствует",
)
