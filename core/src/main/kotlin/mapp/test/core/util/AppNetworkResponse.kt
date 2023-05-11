package mapp.test.core.util

sealed class AppNetworkResponse<out T : Any> {
    /**
     * response with a 2xx status code
     */
    data class Success<out T : Any>(val data: T) : AppNetworkResponse<T>()

    /**
     * response with a non-2xx status code.
     */
    data class Error(val code: Int = -2, val message: String) : AppNetworkResponse<Nothing>()

    object Loading: AppNetworkResponse<Nothing>()

}
