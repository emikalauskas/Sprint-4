package ru.sber.functional

import java.util.function.Predicate

class StudentsGroup {

    private val students: List<Student> = listOf(Student(firstName = "Иван", lastName = "Иванов", middleName = "Иванович", city = "Лобня", averageRate = 4.4),
            Student(firstName = "Сергей", lastName = "Сергеев", averageRate = 4.9),
            Student(firstName = "Андрей", lastName = "Андреев", age = 21, averageRate = 3.8),
            Student(firstName = "Семён", lastName = "Семёнов", middleName = "Семенович", averageRate = 3.5),
            Student(firstName = "Николай", lastName = "Николаев", age = 19, averageRate = 4.7),
            Student(firstName = "Михаил", lastName = "Шуфутинский", middleName = "Захарович", age = 73, city = "Москва",averageRate = 3.09))

    fun filterByPredicate(predicate: (Student) -> Boolean): List<Student> {
        return students.filter{ predicate(it) }
    }
}
