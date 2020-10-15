package com.xiayu.consumers.configuration;

import com.xiayu.log.configuration.RequestTimeAspect;
import com.xiayu.swagger.configuration.Swagger2Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/15 19:49
 */


/**
 * 扫描其他路径下的配置配置文件
 * TxAnoConfig 全局事务处理
 * RequestTimeAspect 全局日志
 */
@ComponentScan(basePackageClasses= {RequestTimeAspect.class, Swagger2Configuration.class})
@Configuration
public class BeanConfiguration {
}
