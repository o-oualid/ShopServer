package com.oualid.shopserver.dtos

data class ItemDto(val id: Long, val name: String, val price: Double, val description: String)
data class CreateItemDto(val name: String, val price: Double, val description: String)