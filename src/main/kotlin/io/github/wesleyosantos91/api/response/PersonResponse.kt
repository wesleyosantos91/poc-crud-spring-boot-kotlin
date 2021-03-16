package io.github.wesleyosantos91.api.response

import java.time.LocalDate

data class PersonResponse(
        val id: Long,
        val name: String,
        val dateOfBirth: LocalDate,
        val cpf: String,
        val email: String
)