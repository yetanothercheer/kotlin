// !LANGUAGE: +NewInference

fun String.toDouble(): Double = (<!DEBUG_INFO_DYNAMIC!>+<!>(this.asDynamic())).unsafeCast<Double>().also {
    if (it.isNaN() && !this.isNaN() || it == 0.0 && this.isBlank())
        TODO()
}

fun String.isNaN(): Boolean = when (this.toLowerCase()) {
    "nan", "+nan", "-nan" -> true
    else -> false
}
