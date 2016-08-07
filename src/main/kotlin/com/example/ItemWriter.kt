package com.example

import org.springframework.batch.item.ItemWriter
import org.springframework.stereotype.Component

/**
 * Created by masahiro on 2016/08/07.
 */
@Component
open class ItemWriter : ItemWriter<String> {
    override fun write(items: MutableList<out String>?) {
        println("[writer]${items}")
    }
}