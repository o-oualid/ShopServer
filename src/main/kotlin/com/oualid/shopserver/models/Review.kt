package com.oualid.shopserver.models

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId

@Entity
data class Review(
    @EmbeddedId
    val id: UserItemKey,
    val rating: Int,
    val comment: String,

    @ManyToOne
    @MapsId("userId")
    val user: User,

    @ManyToOne
    @MapsId("itemId")
    val item: Item
)
