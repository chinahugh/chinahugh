package com.hugh.lenaspringboot.security.mapper;

import com.hugh.lenaspringboot.security.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author PICC
* @description 针对表【s_user_info】的数据库操作Mapper
* @createDate 2022-02-14 22:43:26
* @Entity com.hugh.lenaspringboot.security.entity.UserInfo
*/
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserInfo> findByColumn(String column, String value);
}




