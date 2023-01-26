package io.springbatch.springbatch.domain.joblauncher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;

import lombok.RequiredArgsConstructor;

/**
 * 동기/비동기 실행
 */
// @RestController
@RequiredArgsConstructor
public class JobLauncherController {

    private final Job job;
    private final JobLauncher jobLauncher; // 동기 실행
    private final BasicBatchConfigurer basicBatchConfigurer; // 비동기 실행

    /*
    @PostMapping("/batch")
    public String launch(@RequestBody Member member) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("id", member.getId())
                .addDate("date", new Date())
                .toJobParameters();

        // - 비동기 실행
        SimpleJobLauncher jobLauncher = (SimpleJobLauncher)basicBatchConfigurer.getJobLauncher();
        jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        jobLauncher.run(job, jobParameters);

        // - 동기 실행
        // 1. 수동 배치 실행을 위한 설정값 변경 (application.yml > batch.enabled: false)
        // 2. web 의존성 추가 (spring-boot-starter-web)
        // 3. http 파일 작성 및 IDE 를 통한 http 호출
        // this.jobLauncher.run(job, jobParameters);

        return "batch completed";
    }
    */

}
