package com.oualid.shopserver.services

import com.oualid.shopserver.dtos.UserCreationDto
import com.oualid.shopserver.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun create(user: UserCreationDto):Int {
        //TODO: create user
        return 200
    }
}