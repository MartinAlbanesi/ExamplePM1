package com.example.examplepm1.data.repositories

import com.example.examplepm1.data.models.Item

object SimpleItemRepository {

    // A private list of mocked data.
    private val items = listOf(
        Item(1, "Item 1", "Descripción del item 1"),
        Item(2, "Item 2", "Descripción del item 2"),
        Item(3, "Item 3", "Descripción del item 3"),
        Item(4, "Item 4", "Descripción del item 4"),
        Item(5, "Item 5", "Descripción del item 5"),
        Item(6, "Item 6", "Descripción del item 6"),
        Item(7, "Item 7", "Descripción del item 7"),
        Item(8, "Item 8", "Descripción del item 8"),
        Item(9, "Item 9", "Descripción del item 9"),
        Item(10, "Item 10", "Descripción del item 10"),
        Item(11, "Item 11", "Descripción del item 11"),
        Item(12, "Item 12", "Descripción del item 12"),
        Item(13, "Item 13", "Descripción del item 13"),
        Item(14, "Item 14", "Descripción del item 14"),
        Item(15, "Item 15", "Descripción del item 15"),
        Item(16, "Item 16", "Descripción del item 16"),
        Item(17, "Item 17", "Descripción del item 17"),
        Item(18, "Item 18", "Descripción del item 18"),
        Item(19, "Item 19", "Descripción del item 19"),
        Item(20, "Item 20", "Descripción del item 20")
    )

    fun getItems(): List<Item> {
        return items
    }
}