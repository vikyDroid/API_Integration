package com.vikydroid.demo.learning.coroutines

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

// Imitate a flow of events
fun events(): Flow<Int> = (1..8).asFlow().onEach { delay(100) }

@InternalCoroutinesApi
fun main() = runBlocking<Unit> {
    events()
        .onEach { event ->
//            println("Event: $event")
            check(event != 5)

        }
        .catch {
            println("+++++++ $it")
        }

        .collect {
            println("nummm $it")
        } // <--- Collecting the flow waits
    println("Done")
}