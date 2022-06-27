package com.hugh.lenaspringboot.security.mapper;

import com.hugh.lenaspringboot.security.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Set;

/**
* @author PICC
* @description 针对表【s_role】的数据库操作Mapper
* @createDate 2022-02-14 22:53:18
* @Entity com.hugh.lenaspringboot.security.entity.Role
*/
public interface RoleMapper extends BaseMapper<Role> {
    Set<Role> findByUserId(int userId);
}




