package com.oualid.shopserver.utils

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.stream.Collectors


@JsonIgnoreProperties(
    value = ["pageable", "number", "numberOfElements", "first", "last", "empty"]
)
class SimplePage<T> : PageImpl<T> {

    constructor(content: List<T>, pageable: Pageable, total: Long) : super(content, pageable, total)

    @JsonCreator
    constructor(
        @JsonProperty("content") content: List<T>,
        @JsonProperty("totalElements") totalElements: Long,
        @JsonProperty("totalPages") totalPages: Int,
        @JsonProperty("page") page: Int,
        @JsonProperty("size") size: Int,
        @JsonProperty("sort") sort: List<String>
    ) : super(content, PageRequest.of(page, size, Sort.by(sort.stream().map { el: String ->
            el.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }.map { ar: Array<String> ->
            Sort.Order(Sort.Direction.fromString(ar[1]), ar[0])
        }.collect(Collectors.toList())
    )
    ), totalElements
    )

    fun getPage(): Int {
        return number
    }

    @JsonProperty("sort")
    fun getSortList(): List<String>? {
        return sort.stream().map { order: Sort.Order -> order.property + "," + order.direction.name }
            .collect(Collectors.toList())
    }

}
