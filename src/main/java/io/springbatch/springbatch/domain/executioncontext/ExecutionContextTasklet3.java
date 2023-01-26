package io.springbatch.springbatch.domain.executioncontext;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ExecutionContextTasklet3 implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("[ExecutionContextTasklet3] executed");

        // name 은 ExecutionContextTasklet1, ExecutionContextTasklet2 에서 저장하지 않았던 JobExecution 값이므로 null
        Object name = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("name");

        // 예외 강제 발생 (* 재시도 시 ExecutionContextTasklet4 에서 JobExecution 에 저장한 "name" 을 출력할 수 있는지 확인)
        if (name == null) {
            // JobExecution 공유 데이터 저장 (BATCH_JOB_EXECUTION_CONTEXT)
            chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("name", "user-test");
            // 예외 강제 발생 코드를 해제하고, 이전 실행에서 저장했던 JobExecution 의 데이터를 이후 실행인 ExecutionContextTasklet4 에서 사용 가능한지 확인 (JobExecution - name : user-test)
            // throw new RuntimeException("[ExecutionContextTasklet3] was failed");
        }

        return RepeatStatus.FINISHED;
    }
}
