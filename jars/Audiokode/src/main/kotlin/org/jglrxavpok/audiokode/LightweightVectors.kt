package org.jglrxavpok.audiokode

typealias Vector3D = Triple<Float, Float, Float>

operator fun Vector3D.plus(other: Vector3D) = Vector3D(this.first+other.first, this.second+other.second, this.third+other.third)
operator fun Vector3D.minus(other: Vector3D) = Vector3D(this.first-other.first, this.second-other.second, this.third-other.third)

val Vector3D.x
    get() = first
val Vector3D.y
    get() = second
val Vector3D.z
    get() = third

val NullVector = Vector3D(0f, 0f, 0f)