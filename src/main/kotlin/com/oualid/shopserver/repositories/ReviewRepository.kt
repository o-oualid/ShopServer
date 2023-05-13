package com.oualid.shopserver.repositories

import com.oualid.shopserver.models.Review
import com.oualid.shopserver.models.UserItemKey
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, UserItemKey>