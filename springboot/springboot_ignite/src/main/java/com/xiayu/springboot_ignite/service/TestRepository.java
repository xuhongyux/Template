//package com.xiayu.springboot_ignite.service;
//
//import com.xiayu.springboot_ignite.dto.TestObject;
//import org.apache.ignite.springdata.repository.IgniteRepository;
//import org.apache.ignite.springdata.repository.config.RepositoryConfig;
//import org.springframework.stereotype.Service;
//
///**
// * @author xuhongyu
// * @create 2022-03-03 10:35 上午
// */
//
//@RepositoryConfig(cacheName = "TestCache")
//public interface TestRepository extends IgniteRepository<TestObject, Long>{
//
//    TestObject findById(long id);
//}