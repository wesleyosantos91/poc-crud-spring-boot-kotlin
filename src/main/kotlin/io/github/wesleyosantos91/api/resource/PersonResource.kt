package io.github.wesleyosantos91.api.resource

import io.github.wesleyosantos91.api.request.CreatePersonRequest
import io.github.wesleyosantos91.api.request.UpdatePersonRequest
import io.github.wesleyosantos91.api.response.PersonResponse
import io.github.wesleyosantos91.api.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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