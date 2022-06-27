package com.hugh.leanspringboot.mybatis.dao;

import com.hugh.leanspringboot.mybatis.entity.TSave;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TSave)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 17:49:06
 */
public interface TSaveDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSave queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TSave> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tSave 实例对象
     * @return 对象列表
     */
    List<TSave> queryAll(TSave tSave);

    /**
     * 新增数据
     *
     * @param tSave 实例对象
     * @return 影响行数
     */
    int insert(TSave tSave);

    /**
     * 修改数据
     *
     * @param tSave 实例对象
     * @return 影响行数
     */
    int update(TSave tSave);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    int saveBatch(List<TSave> list);
}
