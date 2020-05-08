package com.gitlab.wesleyosantos91.backend.kotlin.service

import com.gitlab.wesleyosantos91.backend.kotlin.exception.ObjectNotFoundException
import com.gitlab.wesleyosantos91.backend.kotlin.mapper.PersonMapper
import com.gitlab.wesleyosantos91.backend.kotlin.model.Person
import com.gitlab.wesleyosantos91.backend.kotlin.repository.PersonRepository
import com.gitlab.wesleyosantos91.backend.kotlin.request.CreatePersonRequest
import com.gitlab.wesleyosantos91.backend.kotlin.request.UpdatePersonRequest
import com.gitlab.wesleyosantos91.backend.kotlin.response.PersonResponse
import org.springframework.stereotype.Service

/**
 *
 * @author : wesleyosantos91
 * @Date : 07/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
@Service
class PersonService(
        private val personRepository: PersonRepository
) {

    val personMapper = PersonMapper()


    fun findByAll(): List<PersonResponse> {
        return personRepository.findAll().map { personMapper.convertPersonToPersonResponse(it) }
    }

    fun save(createPersonRequest: CreatePersonRequest): PersonResponse? {
        val person = personMapper.convertCreatePersonRequestToPerson(createPersonRequest)

        return personMapper.convertPersonToPersonResponse(personRepository.save(person))
    }

    fun update(id: Long, updatePersonRequest: UpdatePersonRequest): PersonResponse {

        val personSaved = exist(id)
        val person = personMapper.convertUpdatePersonRequestToPerson(updatePersonRequest, personSaved)

        return personMapper.convertPersonToPersonResponse(personRepository.save(person))
    }

    private fun exist(id: Long): Person {
        return personRepository.findById(id).orElseThrow { ObjectNotFoundException("ID $id not found") }
    }

    fun delete(id: Long) {
        personRepository.deleteById(id)
    }
}