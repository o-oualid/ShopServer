package com.oualid.shopserver.dtos

data class ItemDto(
    val id: Long,
    val name: String,
    val price: Double,
    val description: String,
    val image: String,
    val stock: Int,
    val category: String,
    val brand: String
)

data class CreateItemDto(
    val name: String,
    val price: Double,
    val description: String,
    val image: String,
    val stock: Int,
    val category: String,
    val brand: String
)