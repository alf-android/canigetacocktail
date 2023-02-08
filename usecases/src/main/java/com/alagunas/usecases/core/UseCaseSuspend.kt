package com.alagunas.usecases.core

interface UseCaseSuspend<Return> {
    suspend operator fun invoke(): Return
}