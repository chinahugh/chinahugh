package com.hugh.lenaspringboot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hugh.lenaspringboot.security.entity.Role;
import com.hugh.lenaspringboot.security.service.RoleService;
import com.hugh.lenaspringboot.security.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author PICC
* @description 针对表【s_role】的数据库操作Service实现
* @createDate 2022-02-14 22:53:18
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




