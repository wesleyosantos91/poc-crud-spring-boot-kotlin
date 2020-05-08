package com.gitlab.wesleyosantos91.backend.kotlin.model

import java.time.LocalDate
import javax.persistence.*

/**
 *
 * @author : wesleyosantos91
 * @Date : 07/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
@Entity
@Table(name = "Persons")
data class Person(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        val id: Long?,

        @Column(name = "name")
        val name: String,

        @Column(name = "date_of_birth")
        val dateOfBirth: LocalDate,

        @Column(name = "cpf")
        val cpf: String,

        @Column(name = "email")
        val email: String?
) {
        constructor(name: String, dateOfBirth: LocalDate, cpf: String, email: String?) : this(null, name, dateOfBirth, cpf, email)
}