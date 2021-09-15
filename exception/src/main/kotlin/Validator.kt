import ErrorCode.*
import java.util.regex.Pattern
import kotlin.NullPointerException

abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        if (value.isNullOrBlank())
            return listOf(NULL_PARAMETER)
        if (value.length > 16)
            return listOf(INVALID_LENGTH)
        if (!Pattern.compile("[А-Яёа-яЁ]+")
                .matcher(value)
                .matches())
            return listOf(INVALID_CHARACTER)
        return listOf()
    }
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val errorList = ArrayList<ErrorCode>()

        if (value.isNullOrBlank())
            return listOf(NULL_PARAMETER)

        if (!Pattern.compile("[0-9]+")
                        .matcher(value)
                        .matches())
            return listOf(INVALID_CHARACTER)

        if (value.length != 11)
            return listOf(INVALID_LENGTH)

        return listOf()
    }
}

class EmailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val errorList = ArrayList<ErrorCode>()

        if (value.isNullOrBlank())
            return listOf(NULL_PARAMETER)

        if (value.length > 32)
           return listOf(INVALID_LENGTH)

        if (!Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
                .matcher(value)
                .matches())
            return listOf(INVALID_EMAIL)

        return return listOf()
    }
}

class SnilsValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        if (value.isNullOrBlank())
            return listOf(NULL_PARAMETER)

        if (!Pattern.compile("[0-9]*")
                        .matcher(value)
                        .matches())
            return listOf(INVALID_CHARACTER)

        if (value.length != 11)
            return listOf(INVALID_LENGTH)

        val number = value.substring(0, 9)
        val crc = value.substring(9).toInt()
        var sum = number.reversed()
                    .map(Character::getNumericValue)
                    .mapIndexed { index, digit ->
                        digit * (index + 1)
                    }.sum()
        if (sum == 100 || sum == 101)
            sum = 0
        else if (sum > 101)
            sum %= 101

        if (sum != crc)
            return listOf(INVALID_SNILS)

        return listOf()
    }
}