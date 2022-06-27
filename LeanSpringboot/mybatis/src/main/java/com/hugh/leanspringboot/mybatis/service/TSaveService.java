package com.hugh.leanspringboot.mybatis.service;

import com.hugh.leanspringboot.mybatis.entity.TSave;
import java.util.List;

/**
 * (TSave)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 17:49:06
 */
public interface TSaveService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSave queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TSave> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tSave 实例对象
     * @return 实例对象
     */
    TSave insert(TSave tSave);

    /**
     * 修改数据
     *
     * @param tSave 实例对象
     * @return 实例对象
     */
    TSave update(TSave tSave);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
