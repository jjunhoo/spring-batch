package io.springbatch.springbatch.executioncontext;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ExecutionContextTasklet2 implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("[ExecutionContextTasklet2] executed");

        ExecutionContext jobExecutionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
        ExecutionContext stepExecutionContext = chunkContext.getStepContext().getStepExecution().getExecutionContext();

        // ExecutionContextTasklet1 에서 저장한 데이터를 ExecutionContextTasklet2 에서 출력 (공유)
        log.info("[ExecutionContextTasklet2] jobName : " + jobExecutionContext.get("jobName")); // JobExecution 정보는 같은 Job 내에서 공유 가능
        log.info("[ExecutionContextTasklet2] stepName : " + stepExecutionContext.get("stepName"));  // StepExecution 정보는 다른 Step 에서 공유 불가능

        String stepName = chunkContext.getStepContext().getStepExecution().getStepName();

        // ExecutionContextTasklet1 에서 stepName 이 저장되지 않은 경우, ExecutionContextTasklet2 의 stepName 저장
        // Step 간 독립적이기 때문에 데이터 공유 불가로 stepExecutionContext.get("stepName") == null
        if (stepExecutionContext.get("stepName") == null) {
            stepExecutionContext.put("stepName", stepName);
        }


        return RepeatStatus.FINISHED;
    }
}
