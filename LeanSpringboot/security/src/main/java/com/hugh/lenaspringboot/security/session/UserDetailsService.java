package com.hugh.lenaspringboot.security.session;

import com.hugh.lenaspringboot.security.entity.Menu;
import com.hugh.lenaspringboot.security.entity.UserInfo;
import com.hugh.lenaspringboot.security.mapper.MenuMapper;
import com.hugh.lenaspringboot.security.mapper.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author PICC
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private MenuMapper menuMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("UserDetailsService");
        List<UserInfo> users = userInfoMapper.findByColumn("username", username);
        if (users != null && users.size() == 1) {
            UserInfo userInfo = users.get(0);

            Set<Menu> menuSet = menuMapper.findByUserId(userInfo.getId());
            userInfo.setMenus(menuSet);
            return new UserInfoDetails(userInfo);
        }else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }
}
