package com.hugh.lenaspringboot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hugh.lenaspringboot.security.entity.UserInfo;
import com.hugh.lenaspringboot.security.service.UserInfoService;
import com.hugh.lenaspringboot.security.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author PICC
* @description 针对表【s_user_info】的数据库操作Service实现
* @createDate 2022-02-14 22:43:26
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

    @Override
    public List<UserInfo> findByColumn(String column, String value) {
        return baseMapper.findByColumn(column, value);
    }
}




