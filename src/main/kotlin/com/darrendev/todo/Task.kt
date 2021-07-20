package com.darrendev.todo


import javax.persistence.*

@Entity
data class Task(@Id @GeneratedValue val id: Long, var description: String)