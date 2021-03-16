package io.github.wesleyosantos91.api.model

import java.time.LocalDate
import javax.persistence.*

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
        val email: String
) {}