package com.hugh.leanspringboot.mybatis.dao;

import com.hugh.leanspringboot.mybatis.entity.TUserCourse;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TUserCourse)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-12 16:06:02
 */
public interface TUserCourseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    TUserCourse queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TUserCourse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tUserCourse 实例对象
     * @return 对象列表
     */
    List<TUserCourse> queryAll(TUserCourse tUserCourse);

    /**
     * 新增数据
     *
     * @param tUserCourse 实例对象
     * @return 影响行数
     */
    int insert(TUserCourse tUserCourse);

    /**
     * 修改数据
     *
     * @param tUserCourse 实例对象
     * @return 影响行数
     */
    int update(TUserCourse tUserCourse);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

}