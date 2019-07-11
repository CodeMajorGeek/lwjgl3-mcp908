package org.jglrxavpok.audiokode

import java.util.concurrent.ArrayBlockingQueue

class Pool<T : Disposable>(capacity: Int = 1000, val initializer: () -> T): ArrayBlockingQueue<T>(capacity) {

    fun get(): T {
        if(isEmpty()) {
            return initializer()
        }
        return take()
    }
}