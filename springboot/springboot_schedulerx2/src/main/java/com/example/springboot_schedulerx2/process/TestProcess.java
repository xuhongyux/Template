package com.example.springboot_schedulerx2.process;

import com.alibaba.schedulerx.worker.domain.JobContext;
import com.alibaba.schedulerx.worker.processor.JavaProcessor;
import com.alibaba.schedulerx.worker.processor.ProcessResult;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Locale;

/**
 * @author xuhongyu
 * @create 2021-12-02 10:39 上午
 */
@Component
public class TestProcess extends JavaProcessor {
    @Override
    public ProcessResult process(JobContext jobContext) throws Exception {

        System.out.println("JavaProcessor 已经被调用！"+ LocalTime.now().toString());
        return null;
    }
}
