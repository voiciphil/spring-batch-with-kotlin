package com.voiciphil.sbwk.job

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SimpleJobConfig(
    val jobBuilderFactory: JobBuilderFactory
) {
    @Autowired
    @Qualifier("simpleStep1")
    lateinit var simpleStep1: Step

    @Autowired
    @Qualifier("simpleStep2")
    lateinit var simpleStep2: Step

    @Bean("simpleJob")
    fun simpleJob(): Job {
        return jobBuilderFactory.get("simpleJob")
            .start(simpleStep1)
            .next(simpleStep2)
            .build()
    }
}
