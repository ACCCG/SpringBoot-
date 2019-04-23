package club.mymmm.springbootmybatisstudy.mapper;

import club.mymmm.springbootmybatisstudy.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    List<User> findById(int id);

    List<User> findByName(String name);

    void create(User user);

    void delete(int id);

    void update(User user);
}
