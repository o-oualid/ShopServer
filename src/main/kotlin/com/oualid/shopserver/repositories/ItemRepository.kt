package com.oualid.shopserver.repositories

import com.oualid.shopserver.models.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long> {
}