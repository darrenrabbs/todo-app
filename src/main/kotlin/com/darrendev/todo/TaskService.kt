package com.darrendev.todo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class TaskService(val repository: TaskRepository) {
    fun getAll() = repository.findAll()

    fun get(id: Long) : Optional<Task> {
        return repository.findById(id)
    }

    fun save(task: Task) = repository.save(task)

    fun delete(id: Long):  Boolean {
        val found = repository.existsById(id)

        if (found) {
            repository.deleteById(id)
        }

        return found
    }
}