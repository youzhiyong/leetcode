package com.yzy.utils;

import java.util.List;
import java.util.Set;

/**
 * Description:
 * Date: 2019-04-22
 *
 * @author youzhiyong
 */
public interface BaseDao<T> {

    /**
     * 根据ID查询实体
     * @param id 主键
     * @return 实体信息
     */
    T get(Integer id);

    /**
     * 查询实体列表
     * @param t 实体信息
     * @param page 分页信息
     * @return 实体列表
     */
    List<T> listPage(T t/*, Page page*/);

    /**
     * 根据主键集合批量查询列表
     * @param ids 主键集合
     * @return 实体列表
     */
    List<T> batchList(/*@Param("ids") */Set<Integer> ids);

    /**
     * 新增实体
     * @param t 实体信息
     * @return 新增结果（true/false）
     */
    boolean insert(T t);

    /**
     * 更新实体
     * @param t 实体信息
     * @return 更新结果（true/false）
     */
    boolean update(T t);

    /**
     * 物理删除
     * @param id 实体主键
     * @return 删除结果（true/false）
     */
    boolean delete(/*@NotNull*/ Integer id);

    /**
     * 批量物理删除
     * @param ids 主键集合
     * @return 删除结果（true/false）
     */
    boolean batchDelete(/*@NotNull*/ Set<Integer> ids);

}
