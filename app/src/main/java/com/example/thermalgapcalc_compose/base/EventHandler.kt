package com.example.thermalgapcalc_compose.base

interface EventHandler<T> {
    fun obtainEvent(event: T)
}