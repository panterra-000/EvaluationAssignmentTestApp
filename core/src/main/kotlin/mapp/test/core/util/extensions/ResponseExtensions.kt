package mapp.test.core.util.extensions

import com.apollographql.apollo3.api.Error

fun List<Error>.getErrorMessages(): String {
    var allErrors = if (this.size>1) "Errors: \n" else "Error: \n"
    this.forEachIndexed { index, error ->
        allErrors += "${index + 1}. ${error.message} \n"
    }
    return allErrors
}