package com.oualid.shopserver.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val price: Double,
    val description: String,
    val image: String,
    val stock: Int,
    val category: String,
    val brand: String
)
