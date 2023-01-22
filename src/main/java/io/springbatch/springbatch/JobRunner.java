package io.springbatch.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;


// JobLauncher 수동 실행을 위한 클래스
@Component
@RequiredArgsConstructor
public class JobRunner implements ApplicationRunner {

    private final JobLauncher jobLauncher;

    private final Job job; // JobInstanceConfiguration 클래스의 빈 Job 주입

    // JobLauncher 를 수동으로 실행하기 위해 ApplicationRunner 인터페이스를 상속 받아 run() 메소드 오버라이딩
    @Override
    public void run(ApplicationArguments args) throws Exception {

        // JobParametersBuilder 를 통해 JobParameters 생성
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", "user1")
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }

}
