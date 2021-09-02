package com.xiayu.feign.consumer.ray;

import io.ray.api.Ray;

/**
 * @author xuhongyu
 * @create 2021-05-19 14:27
 */
public class Test {
    public static void main(String[] args) {
        // Start Ray runtime. If you're connecting to an existing cluster, you can set
        // the `-Dray.address=<cluster-address>` java system property.
        Ray.init();
    }
}
