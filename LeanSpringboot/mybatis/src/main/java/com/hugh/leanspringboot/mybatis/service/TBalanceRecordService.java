package com.hugh.leanspringboot.mybatis.service;

import com.hugh.leanspringboot.mybatis.entity.TBalanceRecord;
import java.util.List;

/**
 * (TBalanceRecord)表服务接口
 *
 * @author makejava
 * @since 2022-03-14 14:52:13
 */
public interface TBalanceRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBalanceRecord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TBalanceRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tBalanceRecord 实例对象
     * @return 实例对象
     */
    TBalanceRecord insert(TBalanceRecord tBalanceRecord);

    /**
     * 修改数据
     *
     * @param tBalanceRecord 实例对象
     * @return 实例对象
     */
    TBalanceRecord update(TBalanceRecord tBalanceRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}