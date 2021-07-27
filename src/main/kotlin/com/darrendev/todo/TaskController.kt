package com.darrendev.todo

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import java.util.*


@RestController
@RequestMapping("/task")

@Api(description = "This is a task controller")
class TaskController(val service: TaskService) {

    @ApiOperation(value = "This will return a list of tasks", notes = "Empty list returned if nothing exists")
    @GetMapping
    fun tasks() = ResponseEntity.ok(service.getAll())

    @ApiOperation(value = "This will return a task given an task id")
    @GetMapping("/{id}")
    fun tasks(@PathVariable id: Long): ResponseEntity<Optional<Task>> {
        return ResponseEntity.ok(service.get(id))
    }

    @ApiOperation(value = "This will post a task given a description")
    @PostMapping()
    fun create(@RequestBody task: Task): ResponseEntity<Task> {
        val result = service.save(task)
        return ResponseEntity.ok(result)
    }

    @ApiOperation(value = "This will update an existing task given an id")
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody task: Task): ResponseEntity<Task> {
        var t : Task = service.get(id).get()
        t.description = task.description
        val result = service.save(t)
        return ResponseEntity.ok(result)
    }

    @ApiOperation(value = "This will delete a task by task id")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = if (service.delete(id)) {
        ResponseEntity.ok("Task with id $id deleted")
    } else {
        ResponseEntity.status(404).body("Task with id $id not found")
    }

}