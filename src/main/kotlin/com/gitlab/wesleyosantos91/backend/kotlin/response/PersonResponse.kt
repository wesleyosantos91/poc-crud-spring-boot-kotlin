package com.gitlab.wesleyosantos91.backend.kotlin.response

import java.time.LocalDate

/**
 *
 * @author : wesleyosantos91
 * @Date : 07/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
data class PersonResponse(
        val id: Long?,
        val name: String,
        val dateOfBirth: LocalDate,
        val cpf: String,
        val email: String?
)