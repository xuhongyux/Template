package com.xiayu.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-03-03-9:58 上午
 */
@Data
public class UserPo {

    public UserPo(String name,String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String name;

    private String age;

    public static List getListUserPo(){
        List<UserPo> userPos = new ArrayList<>();
        UserPo xiayu = new UserPo("xiayu", "18");
        UserPo xuhongyu = new UserPo("xuhongyu", "18");
        UserPo xiaoming = new UserPo("xiaoming", "19");
        UserPo xiaoming1 = new UserPo("xiaoming", "20");
        UserPo xiaoming2 = new UserPo("xiaoming", "20");

        userPos.add(xiaoming);
        userPos.add(xiayu);
        userPos.add(xuhongyu);
        userPos.add(xiaoming1);
        userPos.add(xiaoming2);
        userPos.add(xiaoming2);
        return  userPos;
    }
}