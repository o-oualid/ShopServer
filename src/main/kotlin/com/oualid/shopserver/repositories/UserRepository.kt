package com.oualid.shopserver.repositories

import com.oualid.shopserver.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>