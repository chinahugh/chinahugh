package com.hugh.leanspringboot.mybatis.service.impl;

import com.hugh.leanspringboot.mybatis.dao.TBalanceRecordDao;
import com.hugh.leanspringboot.mybatis.entity.TBalanceRecord;
import com.hugh.leanspringboot.mybatis.service.TBalanceRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TBalanceRecord)表服务实现类
 *
 * @author makejava
 * @since 2022-03-14 14:52:13
 */
@Service("tBalanceRecordService")
public class TBalanceRecordServiceImpl implements TBalanceRecordService {
    @Resource
    private TBalanceRecordDao tBalanceRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TBalanceRecord queryById(Integer id) {
        return this.tBalanceRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TBalanceRecord> queryAllByLimit(int offset, int limit) {
        List<TBalanceRecord> tBalanceRecords = this.tBalanceRecordDao.queryAllByLimit(offset, limit);
// tBalanceRecords.parallelStream().t
        return tBalanceRecords;
    }

    /**
     * 新增数据
     *
     * @param tBalanceRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TBalanceRecord insert(TBalanceRecord tBalanceRecord) {
        this.tBalanceRecordDao.insert(tBalanceRecord);
        return tBalanceRecord;
    }

    /**
     * 修改数据
     *
     * @param tBalanceRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TBalanceRecord update(TBalanceRecord tBalanceRecord) {
        this.tBalanceRecordDao.update(tBalanceRecord);
        return this.queryById(tBalanceRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tBalanceRecordDao.deleteById(id) > 0;
    }
}
