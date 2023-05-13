package com.oualid.shopserver.services

import com.oualid.shopserver.dtos.AuthResponseDto
import com.oualid.shopserver.dtos.UserCreationDto
import com.oualid.shopserver.dtos.UserLoginDto
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class AuthService(
    val tokenService: TokenService,
    val authenticationManager: AuthenticationManager,
    val userService: UserService
) {

    fun login(userLogin: UserLoginDto): AuthResponseDto {
        val user = UsernamePasswordAuthenticationToken(userLogin.email, userLogin.password)
        val authentication = authenticationManager.authenticate(user)
        return AuthResponseDto(tokenService.generateToken(authentication), "CLIENT", 24)
    }

    @PostMapping("/register")
    fun create(@Validated @RequestBody user: UserCreationDto): ResponseEntity.BodyBuilder {
        return ResponseEntity.status(userService.create(user))
    }
}