package club.mymmm.springbootmybatisstudy.service;

import java.util.List;

public interface BaseService<T> {
    //查询all
    List<T> findAll();

    //根据ID查询
    List<T> findById(int id);

    //添加
    void create(T t);

    //删除
    void delete(int ids);

    //修改
    void update(T t);
}
