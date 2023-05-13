package com.oualid.shopserver.models

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class UserItemKey(
    var userId: Long,
    var itemId: Long
) : Serializable
