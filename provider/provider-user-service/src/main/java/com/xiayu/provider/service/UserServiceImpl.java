package com.xiayu.provider.service;



import com.xiayu.commons.utils.BeanUtil;
import com.xiayu.commons.utils.MapperUtils;
import com.xiayu.provider.api.OrderService;
import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.OrderPo;
import com.xiayu.provider.domain.UserPo;
import com.xiayu.provider.domain.UserExample;
import com.xiayu.provider.mapper.UserMapper;
import com.xiayu.provider.params.OrderVo;
import com.xiayu.provider.params.UserInsertVo;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Date;
import java.util.List;
import java.util.Random;


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
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Reference(version = "1.0.0")
    private OrderService orderService;



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
    public void insert(UserInsertVo userInsertVo)  {

        Random random = new Random(1);
        UserPo userPo = new UserPo();
        MapperUtils.initEntityPo(userPo);
        userPo.setLoginName(userInsertVo.getName());
        userPo.setPassword(passwordEncoder.encode(userInsertVo.getPassword()));
        userPo.setType(userInsertVo.getType());
        userPo.setTel(userInsertVo.getTel());
        //todo用户编号
        userPo.setUserNumber(String.valueOf(random.nextInt(2)));
        userPo.setUserStatus(0);
        userMapper.insert(userPo);
        RuntimeException runtimeException = new RuntimeException("手动生成的异常-测试事务");
       // throw runtimeException;
    }
    @GlobalTransactional
    @Override
    public void updateUser(UserInsertVo userInsertVo) {
        UserPo userPo = new UserPo();
        BeanUtil.copyPropertiesIgnoreNull(userInsertVo,userPo);
        userPo.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(userPo);
        OrderVo orderVo = new OrderVo();
        orderVo.setUserId(userInsertVo.getId());
        orderVo.setInformation(userInsertVo.getPassword());
        orderService.updaOrderByUserId(orderVo);
        int a = 2;
        System.out.println(2);
        throw new RuntimeException("手动异常");
    }
}
