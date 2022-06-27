package com.hugh.lenaspringboot.security.service;

import com.hugh.lenaspringboot.security.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author PICC
* @description 针对表【s_user_info】的数据库操作Service
* @createDate 2022-02-14 22:43:26
*/
public interface UserInfoService extends IService<UserInfo> {
    List<UserInfo> findByColumn(String column, String value);
}
