package com.example

import org.springframework.batch.item.ItemReader
import org.springframework.stereotype.Component

/**
 * Created by masahiro on 2016/08/07.
 */
@Component
open class ItemReader : ItemReader<String> {
    private val array = arrayOf("aaa", "end")
    private var index = 0
    override fun read(): String? {
        println("[reader]$index")
        return if (index < array.size) array[index++] else null
    }
}