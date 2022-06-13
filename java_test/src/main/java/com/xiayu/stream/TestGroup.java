package com.xiayu.stream;

import com.xiayu.admin.User;
import com.xiayu.admin.UserPo;
import org.junit.Test;
import org.testng.collections.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xuhongyu
 * @create 2021-07-21 17:11
 */
public class TestGroup {

    @Test
    public void simpleGroup(){
        List listUserPo = UserPo.getListUserPo();
        Object collect = listUserPo.stream().collect(Collectors.groupingBy(UserPo::getAge));
        System.out.println();

    }


}
