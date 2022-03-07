//package com.xiayu.springboot_ignite.service;
//
//import com.xiayu.springboot_ignite.dto.TestObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author xuhongyu
// * @create 2022-03-03 10:36 上午
// */
//@Service
//public class TestServiceImpl implements TestService {
//    @Autowired
//    TestRepository testRepository;
//
//    @Override
//    public TestObject save(TestObject testObject) {
//        testRepository.save(testObject.getId(), testObject);
//        return  null;
//    }
//
//    @Override
//    public TestObject findTestObjectById(long id) {
//
//        return testRepository.findById(id);
//    }
//}
