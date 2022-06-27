package com.hugh.leanspringboot.mybatis.service.impl;

import com.hugh.leanspringboot.mybatis.dao.TBalanceDao;
import com.hugh.leanspringboot.mybatis.dao.TBalanceRecordDao;
import com.hugh.leanspringboot.mybatis.entity.TBalance;
import com.hugh.leanspringboot.mybatis.entity.TBalanceRecord;
import com.hugh.leanspringboot.mybatis.service.TBalanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * (TBalance)表服务实现类
 *
 * @author makejava
 * @since 2022-03-14 14:51:47
 */
@Service("tBalanceService")
public class TBalanceServiceImpl implements TBalanceService {
    @Resource
    private TBalanceDao tBalanceDao;

    @Resource
    private TBalanceRecordDao tBalanceRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TBalance queryById(Integer id) {
        return this.tBalanceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TBalance> queryAllByLimit(int offset, int limit) {
        return this.tBalanceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tBalance 实例对象
     * @return 实例对象
     */
    @Override
    public TBalance insert(TBalance tBalance) {
        this.tBalanceDao.insert(tBalance);
        return tBalance;
    }

    /**
     * 修改数据
     *
     * @param tBalance 实例对象
     * @return 实例对象
     */
    @Override
    public TBalance update(TBalance tBalance) {
        this.tBalanceDao.update(tBalance);
        return this.queryById(tBalance.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tBalanceDao.deleteById(id) > 0;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public TBalance transaction(int fromId, int toId, double amount) throws Exception {
        TBalance tBalance1 = tBalanceDao.queryById(fromId);
        TBalance tBalance2 = tBalanceDao.queryById(toId);
        BigDecimal bal1 = BigDecimal.valueOf(tBalance1.getBalance());
        BigDecimal bam = BigDecimal.valueOf(amount);
        tBalance1.setBalance(bal1.subtract(bam).doubleValue());
        tBalance2.setBalance(tBalance2.getBalance() + amount);

        int update1 = tBalanceDao.update(tBalance1);
        try {
            System.out.println("update1 = " + update1);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int update2 = tBalanceDao.update(tBalance2);

        TBalanceRecord tBalanceRecord = new TBalanceRecord();
        tBalanceRecord.setFromId(1);
        tBalanceRecord.setToId(2);
        tBalanceRecord.setAmount(amount);
        tBalanceRecord.setInsertime(new Date());
        int a = 1 / 1;
        if (a == 1)
            throw new Exception("11");

        int update = tBalanceRecordDao.insert(tBalanceRecord);

        return null;
    }

}
