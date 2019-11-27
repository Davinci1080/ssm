package com.itcast.mapper;

import com.itcast.pojo.User;

import java.util.List;

public interface UserMapper {

    public User queryUserById(Long id);

    public Long queryTotal();

    public List<User> queryUserAll();

    public int add(User user);

    public int edit(User user);
}
