package com.voiciphil.sbwk.step

import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SimpleJobStepConfig(
    val stepBuilderFactory: StepBuilderFactory
) {
    @Bean("simpleStep1")
    @JobScope
    fun simpleStep1(@Value("#{jobParameters[requestDate]}") requestDate: String?): Step {
        return stepBuilderFactory.get("simpleStep1")
            .tasklet { _, _ ->
                println("simpleStep1")
                println("requestDate: $requestDate")
                RepeatStatus.FINISHED
            }
            .build();
    }

    @Bean("simpleStep2")
    @JobScope
    fun simpleStep2(@Value("#{jobParameters[requestDate]}") requestDate: String?): Step {
        return stepBuilderFactory.get("simpleStep2")
            .tasklet { _, _ ->
                println("simpleStep2")
                println("requestDate: $requestDate")
                RepeatStatus.FINISHED
            }
            .build()
    }
}
