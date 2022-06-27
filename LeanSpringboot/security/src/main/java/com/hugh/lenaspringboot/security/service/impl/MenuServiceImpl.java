package com.hugh.lenaspringboot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hugh.lenaspringboot.security.entity.Menu;
import com.hugh.lenaspringboot.security.service.MenuService;
import com.hugh.lenaspringboot.security.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author PICC
* @description 针对表【s_menu】的数据库操作Service实现
* @createDate 2022-02-15 21:31:08
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




