package com.hugh.leanspringboot.mybatis.service.impl;

import com.hugh.leanspringboot.mybatis.entity.TSave;
import com.hugh.leanspringboot.mybatis.dao.TSaveDao;
import com.hugh.leanspringboot.mybatis.service.TSaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TSave)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 17:49:06
 */
@Service("tSaveService")
public class TSaveServiceImpl implements TSaveService {
    @Resource
    private TSaveDao tSaveDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TSave queryById(Long id) {
        return this.tSaveDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TSave> queryAllByLimit(int offset, int limit) {
        return this.tSaveDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tSave 实例对象
     * @return 实例对象
     */
    @Override
    public TSave insert(TSave tSave) {
        this.tSaveDao.insert(tSave);
        return tSave;
    }

    /**
     * 修改数据
     *
     * @param tSave 实例对象
     * @return 实例对象
     */
    @Override
    public TSave update(TSave tSave) {
        this.tSaveDao.update(tSave);
        return this.queryById(tSave.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tSaveDao.deleteById(id) > 0;
    }

}
