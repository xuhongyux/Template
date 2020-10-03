package com.xiayu.provider.mapper;

import com.xiayu.provider.domain.TestUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 15:29
 */
public interface TestUserMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(TestUser record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(TestUser record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    TestUser selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TestUser record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TestUser record);

    int updateBatch(List<TestUser> list);

    int updateBatchSelective(List<TestUser> list);

    int batchInsert(@Param("list") List<TestUser> list);
}