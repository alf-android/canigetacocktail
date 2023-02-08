package com.alagunas.usecases

interface UseCaseSuspend<Return> {
    suspend operator fun invoke(): Return
}