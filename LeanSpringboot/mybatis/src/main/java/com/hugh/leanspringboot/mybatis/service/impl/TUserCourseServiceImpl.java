package com.hugh.leanspringboot.mybatis.service.impl;

import com.hugh.leanspringboot.mybatis.entity.TUserCourse;
import com.hugh.leanspringboot.mybatis.dao.TUserCourseDao;
import com.hugh.leanspringboot.mybatis.service.TUserCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUserCourse)表服务实现类
 *
 * @author makejava
 * @since 2022-02-12 16:06:02
 */
@Service("tUserCourseService")
public class TUserCourseServiceImpl implements TUserCourseService {
    @Resource
    private TUserCourseDao tUserCourseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public TUserCourse queryById(Long userId) {
        return this.tUserCourseDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TUserCourse> queryAllByLimit(int offset, int limit) {
        return this.tUserCourseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tUserCourse 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TUserCourse insert(TUserCourse tUserCourse) {
        this.tUserCourseDao.insert(tUserCourse);
        return tUserCourse;
    }

    /**
     * 修改数据
     *
     * @param tUserCourse 实例对象
     * @return 实例对象
     */
    @Override
    public TUserCourse update(TUserCourse tUserCourse) {
        this.tUserCourseDao.update(tUserCourse);
        return this.queryById(tUserCourse.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.tUserCourseDao.deleteById(userId) > 0;
    }
}
