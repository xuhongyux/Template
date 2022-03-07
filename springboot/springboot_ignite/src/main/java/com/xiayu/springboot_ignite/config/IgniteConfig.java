package com.xiayu.springboot_ignite.config;

import com.xiayu.springboot_ignite.dto.TestObject;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author xuhongyu
 * @create 2022-03-03 10:33 上午
 */
@Configuration
public class IgniteConfig {

    @Bean
    public Ignite igniteInstance() {

        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
        ipFinder.setAddresses(Arrays.asList("172.16.51.13:47500"));
        spi.setIpFinder(ipFinder);

        IgniteConfiguration igniteConfig = new IgniteConfiguration();
        igniteConfig.setIgniteInstanceName("TestInstance");
        igniteConfig.setDiscoverySpi(spi);
        igniteConfig.setClientMode(true);

        CacheConfiguration cacheConfig = new CacheConfiguration("TestCache");
        cacheConfig.setIndexedTypes(Long.class, TestObject.class);
        igniteConfig.setCacheConfiguration(cacheConfig);
        return Ignition.start(igniteConfig);
    }
}
