package io.github.wesleyosantos91.api.service

import io.github.wesleyosantos91.api.exception.ObjectNotFoundException
import io.github.wesleyosantos91.api.mapper.PersonMapper
import io.github.wesleyosantos91.api.model.Person
import io.github.wesleyosantos91.api.repository.PersonRepository
import io.github.wesleyosantos91.api.request.CreatePersonRequest
import io.github.wesleyosantos91.api.request.UpdatePersonRequest
import io.github.wesleyosantos91.api.response.PersonResponse
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepository: PersonRepository) {

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