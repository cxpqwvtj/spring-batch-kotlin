package com.example

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

/**
 * Created by masahiro on 2016/08/07.
 */
@Component
open class ItemProcessor : ItemProcessor<String, String> {
    override fun process(item: String?): String {
        println("[processor]$item")
        return "processed string"
    }
}