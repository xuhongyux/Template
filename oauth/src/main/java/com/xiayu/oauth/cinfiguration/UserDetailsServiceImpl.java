package com.xiayu.oauth.cinfiguration;

import com.google.common.collect.Lists;
import com.xiayu.commons.entity.TemplateConstants;
import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.UserPo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *  自定义授权模式
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/28 11:34
 */

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 查询用户
        UserPo user = userService.selectUserByName(userName);
        //判断用户是否存在
        if(user == null ){
            return null;
        }
        Integer userStatus = user.getUserStatus();
        Integer delFlag = user.getDelFlag();
        //校验用户状态
        if(userStatus.equals(TemplateConstants.USERSTATUSDISABLE)|| delFlag.equals(TemplateConstants.DELFLAG_OK)){
            return new User("disable", "null", new ArrayList<>());
        }

        // 默认所有用户拥有 USER 权限
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);
        return new User(user.getLoginName(), user.getPassword(), grantedAuthorities);

    }


    //基于内存中的用户
   /* private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$YNUV/BtCel2orbhgrxyPJeljdKVty6yTAL.Cj4v3XhwHWXBkgyPYW";
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 用户名匹配
        if (userName.equals(USERNAME)) {
            List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
            grantedAuthorities.add(grantedAuthority);
            return new User(USERNAME, PASSWORD, grantedAuthorities);
        }
        // 用户名不匹配
        else {
            return null;
        }
    }*/
}
