package org.jglrxavpok.audiokode

import org.lwjgl.openal.AL10.AL_NO_ERROR
import org.lwjgl.openal.AL10.alGetError
import org.lwjgl.openal.AL10

var StreamingBufferSize = 48000

fun checkErrors(info: String = "") {
    val error = alGetError()
    if(error != AL_NO_ERROR)
        println("Error ${getALErrorString(error)} $info")
}

fun getALErrorString(err: Int): String {
    return when (err) {
        AL10.AL_NO_ERROR -> "AL_NO_ERROR"
        AL10.AL_INVALID_NAME -> "AL_INVALID_NAME"
        AL10.AL_INVALID_ENUM -> "AL_INVALID_ENUM"
        AL10.AL_INVALID_VALUE -> "AL_INVALID_VALUE"
        AL10.AL_INVALID_OPERATION -> "AL_INVALID_OPERATION"
        AL10.AL_OUT_OF_MEMORY -> "AL_OUT_OF_MEMORY"
        else -> "Unknown error code $err"
    }
}