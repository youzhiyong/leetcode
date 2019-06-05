package com.yzy.template;

/**
 * Description:
 * Date: 2019-05-23
 *
 * @author youzhiyong
 */
public interface BaseService <T extends BaseModel> {

     void fun(T model);

}
