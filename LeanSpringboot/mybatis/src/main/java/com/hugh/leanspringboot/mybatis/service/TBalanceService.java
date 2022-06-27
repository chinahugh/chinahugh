package com.hugh.leanspringboot.mybatis.service;

import com.hugh.leanspringboot.mybatis.entity.TBalance;
import java.util.List;

/**
 * (TBalance)表服务接口
 *
 * @author makejava
 * @since 2022-03-14 14:51:47
 */
public interface TBalanceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBalance queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TBalance> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tBalance 实例对象
     * @return 实例对象
     */
    TBalance insert(TBalance tBalance);

    /**
     * 修改数据
     *
     * @param tBalance 实例对象
     * @return 实例对象
     */
    TBalance update(TBalance tBalance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    TBalance transaction(int fromId, int toId, double amount) throws Exception;
}
