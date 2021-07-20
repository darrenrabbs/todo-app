package com.darrendev.todo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import java.util.*

val mapper = ObjectMapper().registerModule(KotlinModule())

@RestController
@RequestMapping("/task")

class TaskController(val service: TaskService) {

    @GetMapping
    fun tasks() = ResponseEntity.ok(service.getAll())

    @GetMapping("/{id}")
    fun tasks(@PathVariable id: Long): ResponseEntity<Optional<Task>> {
        return ResponseEntity.ok(service.get(id))
    }

    @PostMapping()
    fun create(@RequestBody task: Task): ResponseEntity<String> {
        val result = service.save(task)
        return ResponseEntity.ok(mapper.writeValueAsString(result))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody task: Task): ResponseEntity<String> {
        var t : Task = service.get(id).get()
        if (task.description != null) {
            t.description = task.description
        }
        val result = service.save(t)
        return ResponseEntity.ok(mapper.writeValueAsString(result))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = if (service.delete(id)) {
        ResponseEntity.ok("Task with id $id deleted")
    } else {
        ResponseEntity.status(404).body("Task with id $id not found")
    }

}