package com.yzy.utils;

/*
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;*/

/**
 * Description:  此接口可作为所有Service接口的基类使用
 * E : 对应的实体类; K : 对应主键类型
 * Date: 2018-10-12
 * @author youzhiyong
 */
public interface BaseService<E, K> {

    /**
     * 新增记录
     *
     * @param entity
     * @return
     * @throws Exception
     */
    int insert(E entity) ;

    /**
     * 根据Id删除记录
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(K id);

    /**
     * 根据ID更新记录
     * 全部更新
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKey(E entity) throws Exception;

    /**
     * 根据Id获取记录
     *
     * @param id
     * @return
     */
    E getByPrimaryKey(K id);

    /*Page<E> findAll(PageRequest pageable);*/
}
