package com.voiciphil.sbwk

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableBatchProcessing
@SpringBootApplication
class SbwkApplication

fun main(args: Array<String>) {
	runApplication<SbwkApplication>(*args)
}
