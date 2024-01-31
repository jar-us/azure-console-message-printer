package com.azureconsoleprinter.app

import kotlinx.coroutines.*
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.InetAddress
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Configuration
class AzureConsoleConfig {

    private val applicationName: String = "Azure Console Message Printer"

    @Bean
    fun initAzureConsoleLogging() = ApplicationRunner {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                val currentDateTime = LocalDateTime.now()
                val formattedDateTime = currentDateTime.format(formatter)
                val hostName = InetAddress.getLocalHost().hostName

                println(
                    "Application: $applicationName, Date: ${formattedDateTime.substringBefore(' ')}, Time: ${
                        formattedDateTime.substringAfter(
                            ' '
                        )
                    }, Host: $hostName"
                )

                delay(1000)
            }
        }
    }
}