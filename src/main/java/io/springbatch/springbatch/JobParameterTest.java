package io.springbatch.springbatch;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/*
@Component
@RequiredArgsConstructor
public class JobParameterTest implements ApplicationRunner {

    private final JobLauncher jobLauncher;

    private final Job job;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 코드를 통한 파라미터 생성 및 바인딩
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", "user1")
                .addLong("seq", 2L)
                .addDate("date", new Date())
                .addDouble("age", 20.5)
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }
}
*/
