package io.springbatch.springbatch.stepcontribution;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * StepContribution
 * - 스프링 배치 청크 프로세스 이해 파트 학습을 통한 추후 이해
 */
/*
@Slf4j
@Configuration
@RequiredArgsConstructor
public class StepContributionConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info("[instanceId] : " + stepContribution.getStepExecution().getJobExecution().getJobInstance().getInstanceId());
                    log.info("[StepContributionConfiguration] - step1 execute");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info("[StepContributionConfiguration] - step2 execute");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
*/