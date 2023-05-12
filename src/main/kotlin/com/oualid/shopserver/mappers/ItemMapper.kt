package com.oualid.shopserver.mappers

import com.oualid.shopserver.dtos.CreateItemDto
import com.oualid.shopserver.dtos.ItemDto
import com.oualid.shopserver.models.Item
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface ItemMapper {

    @Mapping(source = "id", target = "id")
    fun itemToDto(item: Item): ItemDto

    @InheritInverseConfiguration
    fun dtoToItem(item: ItemDto): Item

    fun createItemDtoToItem(item: CreateItemDto): Item

}