package com.oualid.shopserver.services

import com.oualid.shopserver.dtos.CreateItemDto
import com.oualid.shopserver.dtos.ItemDto
import com.oualid.shopserver.mappers.ItemMapper
import com.oualid.shopserver.models.Item
import com.oualid.shopserver.repositories.ItemRepository
import com.oualid.shopserver.utils.SimplePage
import org.mapstruct.factory.Mappers
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class ItemService(val itemRepository: ItemRepository) {
    fun getItems(pageable: Pageable): SimplePage<ItemDto> {
        val page = itemRepository.findAll(pageable)
        return SimplePage(
            page.content
                .map { Mappers.getMapper(ItemMapper::class.java).itemToDto(it) }, pageable,
            page.totalElements
        )
    }

    fun addItem(item: CreateItemDto): ItemDto {
        val itemEntity = Mappers.getMapper(ItemMapper::class.java).createItemDtoToItem(item)
        val savedItem = itemRepository.save(itemEntity)
        return Mappers.getMapper(ItemMapper::class.java).itemToDto(savedItem)
    }

    fun getItem(id: Long, pageable: Pageable): SimplePage<ItemDto> {

        return SimplePage(
            listOf(Mappers.getMapper(ItemMapper::class.java).itemToDto(Item(0, "di", 74.55, "dd"))), pageable, 4
        )
    }
}