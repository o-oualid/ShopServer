package com.oualid.shopserver.repositories

import com.oualid.shopserver.models.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository<Cart, Long>