package com.azureconsoleprinter.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AzureConsoleMessagePrinterApplication

fun main(args: Array<String>) {
    runApplication<AzureConsoleMessagePrinterApplication>(*args)
    Thread.currentThread().join()
}
