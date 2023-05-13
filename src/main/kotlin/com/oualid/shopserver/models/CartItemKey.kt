package com.oualid.shopserver.models

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class CartItemKey(
    var cartId: Long,
    var itemId: Long
): Serializable
