package io.springbatch.springbatch.jobrepository;

import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobRepositoryListener implements JobExecutionListener {

    private final JobRepository jobRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();

        // BATCH_JOB_EXECUTION_PARAMS 에 저장된 Parameter 값
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", "testuser")
                .toJobParameters();

        // JobRepository 에서 제공하는 getLastJobExecution() 를 통해 가장 마지막에 실행된 JobExecution 정보 추출
        JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);

        if (lastJobExecution != null) {
            for (StepExecution stepExecution : lastJobExecution.getStepExecutions()) {
                Long jobExecutionId = stepExecution.getJobExecutionId();
                log.info("[jobExecutionId] : " + jobExecutionId);
                String stepName = stepExecution.getStepName();
                log.info("[stepName] : " + stepName);
                BatchStatus status = stepExecution.getStatus();
                log.info("[status] : " + status);
                ExitStatus exitStatus = stepExecution.getExitStatus();
                log.info("[exitStatus] : " + exitStatus);
            }
        }
    }
}
