package com.gitlab.wesleyosantos91.backend.kotlin.mapper

import com.gitlab.wesleyosantos91.backend.kotlin.model.Person
import com.gitlab.wesleyosantos91.backend.kotlin.request.CreatePersonRequest
import com.gitlab.wesleyosantos91.backend.kotlin.request.UpdatePersonRequest
import com.gitlab.wesleyosantos91.backend.kotlin.response.PersonResponse

/**
 *
 * @author : wesleyosantos91
 * @Date : 07/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
class PersonMapper {

    fun convertCreatePersonRequestToPerson(createPersonRequest: CreatePersonRequest): Person {
        return Person(name = createPersonRequest.name,
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
        return PersonResponse(id = person.id,
                                name = person.name,
                                dateOfBirth = person.dateOfBirth,
                                cpf = person.cpf,
                                email = person.email)
    }
}