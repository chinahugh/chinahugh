package com.hugh.leanspringboot.base.async.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author ruoyi
 **/

@EnableAsync
@Configuration
public class ThreadPoolConfig {
    // 核心线程池大小
    @Value("${spring.task.execution.pool.core-size}")
    private int corePoolSize = 1;//Runtime.getRuntime().availableProcessors();

    // 最大可创建的线程数
    @Value("${spring.task.execution.pool.max-size}")
    private int maxPoolSize = 1;//Runtime.getRuntime().availableProcessors() * 2 + 1;

    // 队列最大长度
    private int queueCapacity = 2;

    // 线程池维护线程所允许的空闲时间
    private int keepAliveSeconds = 300;

    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        System.out.println(" start------------------------ " );
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 线程池对拒绝任务(无线程可用)的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("my - async - thread");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }



//    /**
//     * 执行周期性或定时任务
//     */
//    @Bean(name = "scheduledExecutorService")
//    protected ScheduledExecutorService scheduledExecutorService()
//    {
//        return new ScheduledThreadPoolExecutor(corePoolSize,
//                new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build(),
//                new ThreadPoolExecutor.CallerRunsPolicy())
//        {
//            @Override
//            protected void afterExecute(Runnable r, Throwable t)
//            {
//                super.afterExecute(r, t);
//                Threads.printException(r, t);
//            }
//        };
//    }
}
