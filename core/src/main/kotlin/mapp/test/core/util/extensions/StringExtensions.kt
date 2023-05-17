package mapp.test.core.util.extensions

fun String?.checkAndGetValue(): String {
    if (this == "null") {
        return "Unknown"
    }
    return this ?: "Unknown"
}
