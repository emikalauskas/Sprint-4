class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(", ") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    INVALID_CHARACTER(100, "Недопустимый символ"),
    INVALID_LENGTH(101, "Неверная длина параметра"),
    NULL_PARAMETER(102, "Параметр null"),
    INVALID_EMAIL(103, "Неверный email"),
    INVALID_SNILS(104, "Неверное контрольное число"),
    // ...
}