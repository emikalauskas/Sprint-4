package ru.sber.generics

import com.sun.org.apache.xpath.internal.operations.Bool
import io.mockk.InternalPlatformDsl.toArray
import java.util.*

// 1.
fun compare(p1: Pair<Any?, Any?>, p2: Pair<Any?, Any?>): Boolean {
    if (p1 == p2)
        return true
    return false
}

// 2.
fun countGreaterThan(anArray: Array<Any?>, elem: Any?): Int {
    val array = anArray.plusElement(elem)
    var cnt = 0
    array.sort()
    while (array[cnt] != elem) {
        cnt++
    }
    return cnt
}

// 3.
class Sorter<T : Comparable<T>> {
    val list: MutableList<T> = mutableListOf()

    fun add(value: T) {
        list.add(value)
        list.sort()
    }
}

// 4.
class Stack<T> {
    private val list: MutableList<T> = mutableListOf()

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    fun push(value: T) {
        list.add(value)
    }

    fun pop(): T {
        return list.removeLast()
    }
}