package ru.sber.functional

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StudentsGroupTest {
    class PowFactoryTest {
        @Test
        fun `filterByPredicate should return students who have middleName`() {
            val students = listOf(Student(firstName = "Иван", lastName = "Иванов", middleName = "Иванович", city = "Лобня", averageRate = 4.4),
                    Student(firstName = "Семён", lastName = "Семёнов", middleName = "Семенович", averageRate = 3.5),
                    Student(firstName = "Михаил", lastName = "Шуфутинский", middleName = "Захарович", age = 73, city = "Москва",averageRate = 3.09));
            assertEquals(students, StudentsGroup().filterByPredicate { it.middleName != "Отсутствует" })
        }

        @Test
        fun `filterByPredicate should return students who have age`() {
            val students = listOf(Student(firstName = "Андрей", lastName = "Андреев", age = 21, averageRate = 3.8),
                    Student(firstName = "Николай", lastName = "Николаев", age = 19, averageRate = 4.7),
                    Student(firstName = "Михаил", lastName = "Шуфутинский", middleName = "Захарович", age = 73, city = "Москва",averageRate = 3.09));
            assertEquals(students, StudentsGroup().filterByPredicate { it.age > 0 })
        }

        @Test
        fun `filterByPredicate should return students who have city`() {
            val students = listOf(Student(firstName = "Иван", lastName = "Иванов", middleName = "Иванович", city = "Лобня", averageRate = 4.4),
                    Student(firstName = "Михаил", lastName = "Шуфутинский", middleName = "Захарович", age = 73, city = "Москва",averageRate = 3.09));
            assertEquals(students, StudentsGroup().filterByPredicate { it.city != "" })
        }

        @Test
        fun `filterByPredicate should return students who have averageRate more than 4,5`() {
            val students = listOf(Student(firstName = "Сергей", lastName = "Сергеев", averageRate = 4.9),
                    Student(firstName = "Николай", lastName = "Николаев", age = 19, averageRate = 4.7));
            assertEquals(students, StudentsGroup().filterByPredicate { it.averageRate > 4.5 })
        }
    }
}