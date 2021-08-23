package com.practice.kotlin

object MySingletonK {
    @Volatile
    private var mInstance // write happens-before
            : MySingletonK? = null

    val instance: MySingletonK?
        get() {
            if (mInstance == null) {
                synchronized(MySingletonK::class.java) { if (mInstance == null) mInstance = MySingletonK }
            }
            return mInstance
        }
}