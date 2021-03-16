package io.github.wesleyosantos91.api.mapper

import io.github.wesleyosantos91.api.model.Person
import io.github.wesleyosantos91.api.request.CreatePersonRequest
import io.github.wesleyosantos91.api.request.UpdatePersonRequest
import io.github.wesleyosantos91.api.response.PersonResponse

class PersonMapper {

    fun convertCreatePersonRequestToPerson(createPersonRequest: CreatePersonRequest): Person {
        return Person(id = null,
                        name = createPersonRequest.name,
                        dateOfBirth = createPersonRequest.dateOfBirth,
                        cpf = createPersonRequest.cpf,
                        email = createPersonRequest.email)
    }

    fun convertUpdatePersonRequestToPerson(updatePersonRequest: UpdatePersonRequest, person: Person): Person {
        return person.copy(name = updatePersonRequest.name,
                        dateOfBirth = updatePersonRequest.dateOfBirth,
                        cpf = updatePersonRequest.cpf,
                        email = updatePersonRequest.email)
    }

    fun convertPersonToPersonResponse(person: Person): PersonResponse {
        return PersonResponse(id = person.id!!,
                                name = person.name,
                                dateOfBirth = person.dateOfBirth,
                                cpf = person.cpf,
                                email = person.email)
    }
}