package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*

// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    val set: MutableSet<String> = mutableSetOf()
    ZoneOffset.getAvailableZoneIds().forEach { zoneId ->
        if (ZoneId.of(zoneId).rules.getOffset(Instant.now()).totalSeconds % 3600 != 0)
            set.add(zoneId)
    }
    return set
}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {
    val list: MutableList<String> = mutableListOf()
    for (month in 1..12) {
        val date = LocalDate.of(year, month, LocalDate.of(year, month, 1).lengthOfMonth())
        list.add(date.dayOfWeek.toString())
    }
    return list
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {
    var cnt = 0
    for (month in 1..12) {
        if (LocalDate.of(year, month, 13).dayOfWeek == DayOfWeek.FRIDAY)
            cnt++
    }
    return cnt
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {
    return DateTimeFormatter.ofPattern("dd MMM YYYY, HH:mm", Locale.US).format(dateTime)
}



