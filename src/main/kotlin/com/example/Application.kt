package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

@SpringBootApplication
@EnableAutoConfiguration(exclude = arrayOf(DataSourceAutoConfiguration::class))
open class Application {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            System.exit(SpringApplication.exit(SpringApplication.run(Application::class.java, *args)))
        }
    }
}
