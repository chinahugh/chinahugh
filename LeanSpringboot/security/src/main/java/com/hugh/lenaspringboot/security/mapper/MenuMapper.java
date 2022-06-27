package com.hugh.lenaspringboot.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hugh.lenaspringboot.security.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
* @author PICC
* @description 针对表【s_menu】的数据库操作Mapper
* @createDate 2022-02-15 21:31:08
* @Entity com.hugh.lenaspringboot.security.entity.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    Set<Menu> findByUserId(Integer userId);
}




