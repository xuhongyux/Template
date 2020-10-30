package com.xiayu.springboot_demo.configuration;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *      事务配置tx
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/28 16:01
 */
@Configuration
public class TxAnoConfiguration {

    private static final int TX_METHOD_TIMEOUT = 5;

    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.xiayu.springboot_demo.service.*.*(..))";

    /*事务拦截属性配置*/
    @Bean("txSource")
    public TransactionAttributeSource transactionAttributeSource(){
        /**
         * 创建一个用来收集事务属性的对象
         * NameMatchTransactionAttributeSource 通过名称匹配资源
         */
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        /**
         * 创建事务规则
         * 只读事务，不做更新操作
         **/
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        //设置传播行为 当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED );
        //设置回滚规则
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        //超时时间
        requiredTx.setTimeout(TX_METHOD_TIMEOUT);

        //将名称资源和事务规则封装
        Map<String, TransactionAttribute> txMap = new HashMap<>();
        txMap.put("create*", requiredTx);
        txMap.put("insert*", requiredTx);
        txMap.put("update*", requiredTx);
        txMap.put("delete*", requiredTx);
        txMap.put("get*", readOnlyTx);
        txMap.put("select*", readOnlyTx);
        source.setNameMap( txMap );

        return source;
    }


    /*事务拦截器*/
    @Bean("txInterceptor")
    TransactionInterceptor getTransactionInterceptor(PlatformTransactionManager tx){
        return new TransactionInterceptor(tx , transactionAttributeSource()) ;
    }


    /**切面拦截规则 参数会自动从容器中注入*/
    @Bean
    public AspectJExpressionPointcutAdvisor pointcutAdvisor(TransactionInterceptor txInterceptor){
        AspectJExpressionPointcutAdvisor pointcutAdvisor = new AspectJExpressionPointcutAdvisor();
        pointcutAdvisor.setAdvice(txInterceptor);
        pointcutAdvisor.setExpression(AOP_POINTCUT_EXPRESSION);
        return pointcutAdvisor;
    }


}
