package com.example.demo

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@SpringBootApplication
class DemoApplication {
    @Primary
    @Bean
    fun jdbcTemplate1(dataSource: HikariDataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
