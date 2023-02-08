package com.alagunas.data

sealed class MyResult<out S, out F> {
    object Loading : MyResult<Nothing, Nothing>()
    data class Success<S>(val data: S) : MyResult<S, Nothing>()
    data class Error<F>(val error: F) : MyResult<Nothing, F>()
    object NoInternet : MyResult<Nothing, Nothing>()
}

inline fun <S, F, R> MyResult<S, F>.fold(
    ifLoading: () -> R,
    onSuccess: (S) -> R,
    onError: (F) -> R,
    ifNoInternet: () -> R
) = when (this) {
    is MyResult.Loading -> ifLoading()
    is MyResult.Success -> onSuccess(data)
    is MyResult.Error -> onError(error)
    is MyResult.NoInternet -> ifNoInternet()
}

val MyResult<*, *>.succeeded
    get() = this is MyResult.Success && data != null