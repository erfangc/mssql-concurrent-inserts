package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.jdbc.core.SqlParameter
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.simple.SimpleJdbcCall
import org.springframework.stereotype.Component
import java.sql.Types
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

@Component
class Runner(private val jdbcTemplate1: NamedParameterJdbcTemplate) : CommandLineRunner {

    private val log: Logger = LoggerFactory.getLogger(Runner::class.java)

    override fun run(vararg args: String?) {

        val id = UUID.randomUUID().toString()
        val e = Executors.newFixedThreadPool(5)
        log.info("Running for $id")

        for (i in 1..5) {
            e.submit {
                try {
                    val jdbcCall = SimpleJdbcCall(jdbcTemplate1.jdbcTemplate)
                        .withProcedureName("my_proc")
                    
                    jdbcCall.addDeclaredParameter(SqlParameter("id", Types.VARCHAR))
                    jdbcCall.addDeclaredParameter(SqlParameter("asset", Types.VARCHAR))
                    jdbcCall.addDeclaredParameter(SqlParameter("qty", Types.NUMERIC))
                    
                    val result = jdbcCall.execute(mapOf("id" to id, "asset" to "0123456789", "qty" to 1000.0))
                    log.info("result=$result")
                } catch (e: Exception) {
                    log.error(e.message)
                }
            }
        }
        e.awaitTermination(1, TimeUnit.MINUTES)
        exitProcess(0)
    }

}