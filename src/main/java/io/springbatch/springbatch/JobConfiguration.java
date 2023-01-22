package io.springbatch.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    /**
     * Job 정의
     * - SimpleJob, FlowJob, GroupAwareJob, JsrFlowJob
     * @return
     */
    /*
    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(step1()) // SimpleJobBuilder > start()
                .next(step2()) // SimpleJobBuilder > next() : private List<Step> steps = new ArrayList(); 에 해당 step 을 add()
                .build(); // SimpleJobBuilder > build()
    }
    */

    /**
     * Step 정의
     * @return
     */
    /*
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        log.info("[step1] - execute");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
    */

    /**
     * Step 정의
     * @return
     */
    /*
    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        log.info("[step2] - execute");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
    */
}
