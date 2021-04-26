package com.xiayu.springboot_demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author xuhongyu
 * @create 2021-04-26 10:30
 */

@Component
public class TestAsync {

    @Async
    public Future<String> testAsync (String str) throws IOException, InterruptedException {
        Thread.sleep(2000);
        AsyncResult<String> objectAsyncResult = new AsyncResult<>(str);
        return  objectAsyncResult;
    }
}
