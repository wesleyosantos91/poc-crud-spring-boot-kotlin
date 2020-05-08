package com.gitlab.wesleyosantos91.backend.kotlin.repository

import com.gitlab.wesleyosantos91.backend.kotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 * @author : wesleyosantos91
 * @Date : 07/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
@Repository
interface PersonRepository : JpaRepository<Person, Long> {
}