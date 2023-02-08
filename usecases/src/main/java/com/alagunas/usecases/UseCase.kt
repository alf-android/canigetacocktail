package com.alagunas.usecases

interface UseCase<Params, Return> {
    operator fun invoke(params: Params): Return
}