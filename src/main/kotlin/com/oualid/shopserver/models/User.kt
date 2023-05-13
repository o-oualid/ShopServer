package com.oualid.shopserver.models

import jakarta.persistence.*
import jakarta.validation.constraints.Email

@Entity(name = "user_table")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val firstName: String,

    val lastName: String,

    val email: String,

    @Email
    val password: String,

    @Enumerated(EnumType.STRING)
    val role: Role,

    @OneToMany(mappedBy = "user")
    val carts: List<Cart>
)
