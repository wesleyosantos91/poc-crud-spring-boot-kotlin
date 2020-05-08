package com.gitlab.wesleyosantos91.backend.kotlin.resource

import com.gitlab.wesleyosantos91.backend.kotlin.mapper.PersonMapper
import com.gitlab.wesleyosantos91.backend.kotlin.request.CreatePersonRequest
import com.gitlab.wesleyosantos91.backend.kotlin.request.UpdatePersonRequest
import com.gitlab.wesleyosantos91.backend.kotlin.response.PersonResponse
import com.gitlab.wesleyosantos91.backend.kotlin.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

/**
 *
 * @author : wesleyosantos91
 * @Date : 07/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
@RestController
@RequestMapping("persons")
class PersonResource (
        private val personService: PersonService
) {

    @GetMapping
    fun findByAll(): ResponseEntity<List<PersonResponse>> {
        return ResponseEntity.ok(personService.findByAll())
    }

    @PostMapping
    fun save(@RequestBody createPersonRequest: CreatePersonRequest): ResponseEntity<PersonResponse>  {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(createPersonRequest))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {

        return ResponseEntity.ok(personService.update(id, updatePersonRequest))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {

        personService.delete(id)
        return ResponseEntity.noContent().build()
    }

}