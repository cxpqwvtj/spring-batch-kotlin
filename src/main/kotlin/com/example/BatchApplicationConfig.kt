package com.example

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by masahiro on 2016/08/07.
 */
@Configuration
@EnableBatchProcessing
open class BatchApplicationConfig {

//    @Autowired
//    lateinit private var jobs: JobBuilderFactory

    @Autowired
    lateinit private var steps: StepBuilderFactory

    @Autowired
    lateinit private var reader: ItemReader

    @Autowired
    lateinit private var processor: ItemProcessor

    @Autowired
    lateinit private var writer: ItemWriter

    @Bean
    open fun job(jobs: JobBuilderFactory, s1: Step, s2: Step): Job {
        return jobs.get("myJob").incrementer(RunIdIncrementer()).flow(s1).next(s2).end().build()
    }

    @Bean(name = arrayOf("s1"))
    open fun step1(): Step {
        return steps.get("step1").tasklet({ stepContribution, chunkContext ->
            println("step 1")
            RepeatStatus.FINISHED
        }).build()
    }

    @Bean(name = arrayOf("s2"))
    open fun step2(): Step {
        return steps.get("step2")
                .chunk<String, String>(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build()
    }
}