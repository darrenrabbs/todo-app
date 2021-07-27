package com.darrendev.todo


import io.swagger.annotations.ApiModelProperty
import javax.persistence.*

@Entity
data class Task(@ApiModelProperty(value = "auto-generated id") @Id @GeneratedValue val id: Long,
                @ApiModelProperty(value = "Description of task", required = true) var description: String)