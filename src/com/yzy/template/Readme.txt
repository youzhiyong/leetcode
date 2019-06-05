泛型类、泛型方法的使用测试


test1:
ModelA 继承于 BaseModel
BaseService接口中定义了一个泛型方法，如下：

public interface BaseService {
    <T extends BaseModel> void fun(T model);
}

ServiceImpl类实现了BaseService接口，想将泛型T 转换成 ModelA，但是无法实现,如下:

public class ServiceImpl implements BaseService {

    //error
    @Override
    public void fun(ModelA model) {

    }

    //error
    @Override
    public <T extends ModelA> void fun(T model) {

    }

    //只能这样来重写，不能指定具体的参数类型
    @Override
    public <T extends BaseModel> void fun(T model) {

    }
}


test2:
想要实现这样的功能，只能将泛型方法 <T extends BaseModel> void fun(T model); 中的泛型提取为泛型接口，即将BaseService接口改为：
public interface BaseService <T extends BaseModel> {
    void fun(T model);
}

ServiceImpl类改为：
public class ServiceImpl implements BaseService<ModelA> {

    @Override
    public void fun(ModelA model) {

    }
}
