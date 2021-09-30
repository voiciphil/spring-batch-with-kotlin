package com.voiciphil.sbwk.job

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SimpleJobConfiguration(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory
) {
    @Bean("simpleJob")
    fun simpleJob(): Job {
        return jobBuilderFactory.get("simpleJob")
            .start(simpleStep1())
            .build()
    }

    @Bean("simpleStep1")
    fun simpleStep1(): Step {
        return stepBuilderFactory.get("simpleStep1")
            .tasklet { _, _ ->
                println("simpleStep1")
                RepeatStatus.FINISHED
            }
            .build();
    }
}
