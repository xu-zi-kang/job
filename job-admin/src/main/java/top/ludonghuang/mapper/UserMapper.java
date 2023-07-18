package top.ludonghuang.mapper;

import top.ludonghuang.entity.User;

import java.util.List;

public interface UserMapper {

    int create(User user);

    int delete(Integer id);

    int update(User user);

    List<User> query(User user);

    int count(User user);

    User detail(Integer id);

}
