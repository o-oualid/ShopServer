package com.oualid.shopserver.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class UserDto(
    val id: Long, val firstName: String,
    val lastName: String,
    val email: String,
    @Email
    val password: String,
    val role: String
)

data class UserCreationDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    @Email
    val password: String
)

data class UserLoginDto(
    @Email val email: String,
    @NotEmpty val password: String
)

data class AuthResponseDto(val token: String,val role: String,val ttl: Long)