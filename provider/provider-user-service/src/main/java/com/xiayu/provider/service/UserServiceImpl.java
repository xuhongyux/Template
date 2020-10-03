package com.xiayu.provider.service;
import java.util.Date;


import com.xiayu.commons.utils.MapperUtils;
import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.TestUser;
import com.xiayu.provider.domain.UserPo;
import com.xiayu.provider.domain.UserExample;
import com.xiayu.provider.mapper.TestUserMapper;
import com.xiayu.provider.mapper.UserMapper;
import com.xiayu.provider.params.UserInsertVo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 17:52
 */

@Service(version = "1.0.0", timeout = 30000)
public class UserServiceImpl implements UserService {

    @Autowired
    private TestUserMapper testUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public TestUser getUser() {
        TestUser testUser = testUserMapper.selectByPrimaryKey(1L);
        return testUser;
    }


    @Override
    public List<UserPo> getUsers() {
        UserExample userExample = new UserExample();
        userExample.createCriteria();
        List<UserPo> userPos = userMapper.selectByExample(userExample);
        if(!MapperUtils.isBlankCollection(userPos)){
            return userPos;
        }
        return null;

    }

    @Override
    public UserPo selectUserByName(String userName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(userName).andDelFlagEqualTo(0);
        List<UserPo> userPos = userMapper.selectByExample(userExample);
        if(!MapperUtils.isBlankCollection(userPos)){
            return userPos.get(0);
        }
        return null;
    }

    @Override
    public void insert(UserInsertVo userInsertVo) {
        UserPo userPo = new UserPo();
        MapperUtils.initEntityPo(userPo);
        userPo.setLoginName(userInsertVo.getName());
        userPo.setPassword(passwordEncoder.encode(userInsertVo.getPassword()));
        userPo.setType(userInsertVo.getType());
        userPo.setTel(userInsertVo.getTel());
        //todo用户编号
        userPo.setUserNumber("");
        userPo.setUserStatus(0);
        userMapper.insert(userPo);


    }
}
