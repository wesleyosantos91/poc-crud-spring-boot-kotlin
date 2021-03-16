package io.github.wesleyosantos91.api.repository

import io.github.wesleyosantos91.api.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {
}