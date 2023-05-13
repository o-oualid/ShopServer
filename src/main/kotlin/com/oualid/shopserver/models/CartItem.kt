package com.oualid.shopserver.models

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId

@Entity
data class CartItem(
    @EmbeddedId
    val id: CartItemKey,

    @ManyToOne
    @MapsId("cartId")
    val cart: Cart,

    @ManyToOne
    @MapsId("itemId")
    val item: Item,

    val quantity: Int
)
