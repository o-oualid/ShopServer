package com.oualid.shopserver.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class Cart(
    @Id
    val id: Long,

    @ManyToOne
    val user: User,
)
