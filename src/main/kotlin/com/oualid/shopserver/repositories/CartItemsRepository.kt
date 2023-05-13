package com.oualid.shopserver.repositories

import com.oualid.shopserver.models.CartItem
import com.oualid.shopserver.models.CartItemKey
import org.springframework.data.jpa.repository.JpaRepository

interface CartItemsRepository : JpaRepository<CartItem, CartItemKey>