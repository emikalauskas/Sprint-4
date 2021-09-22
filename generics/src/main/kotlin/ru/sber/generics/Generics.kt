package ru.sber.generics

import com.sun.org.apache.xpath.internal.operations.Bool
import io.mockk.InternalPlatformDsl.toArray
import java.util.*

// 1.
fun <T1, T2> compare(p1: Pair<T1, T2>, p2: Pair<T1, T2>): Boolean {
    if (p1 == p2)
        return true
    return false
}

// 2.
fun <T : Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int {
    var cnt = 0
    for (arrElem in anArray) {
        if (arrElem > elem)
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