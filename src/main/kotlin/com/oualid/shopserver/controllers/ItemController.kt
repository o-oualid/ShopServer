package com.oualid.shopserver.controllers

import com.oualid.shopserver.dtos.CreateItemDto
import com.oualid.shopserver.dtos.ItemDto
import com.oualid.shopserver.services.ItemService
import com.oualid.shopserver.utils.SimplePage
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.SortDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController()
class ItemController(val itemService: ItemService) {
    @GetMapping("/items")
    fun getItems(
        @SortDefault(sort = ["id"])
        @PageableDefault(size = 20) pageable: Pageable
    ): ResponseEntity<SimplePage<ItemDto>> {
        return ResponseEntity.ok(itemService.getItems(pageable))
    }

    @PostMapping("/items")
    fun addItem(@RequestBody item: CreateItemDto): ResponseEntity<ItemDto> {
        return ResponseEntity.ofNullable(itemService.addItem(item))
    }

    @DeleteMapping("items/{id}")
    fun deleteItem(@PathVariable id: Long): ResponseEntity<String> {
        return ResponseEntity.ok("Hello $id")
    }

    @GetMapping("items/{id}")
    fun getItem(
        @SortDefault(sort = ["id"])
        @PageableDefault(size = 20) pageable: Pageable, @PathVariable id: Long
    ): ResponseEntity<SimplePage<ItemDto>> {
        return ResponseEntity.ok(itemService.getItem(id, pageable))
    }
}