package io.springbatch.springbatch.jobrepository;

import javax.sql.DataSource;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class CustomBatchConfigurer extends BasicBatchConfigurer {

    private final DataSource dataSource;

    protected CustomBatchConfigurer(BatchProperties properties, DataSource dataSource, TransactionManagerCustomizers transactionManagerCustomizers) {
        super(properties, dataSource, transactionManagerCustomizers);
        this.dataSource = dataSource;
    }

    // BasicBatchConfigurer 의 createJobRepository() 이 아닌 CustomBatchConfigurer 의 오버라이딩 된 createJobRepository() 사용
    @Override
    protected JobRepository createJobRepository() throws Exception {

        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource); // datasource 설정
        factory.setTransactionManager(getTransactionManager()); // TransactionManager 설정
        factory.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED"); // ISOLATION 레벨 설정
        factory.setTablePrefix("SYSTEM_"); // prefix 설정 (실행 시 SYSTEM_ 의 테이블이 생성되지 않았기 때문에 에러 발생)

        return factory.getObject();
    }
}
