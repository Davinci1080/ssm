package com.itcast.service;

import com.itcast.mapper.UserMapper;
import com.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public Long queryTotal() {
        Long aLong = userMapper.queryTotal();
        return aLong;
    }

    public List<User> queryUserAll() {
        List<User> users = userMapper.queryUserAll();
        return users;
    }

    public void insert(User user1,User user2) {
        this.userMapper.add(user1);
        System.out.println(user1);

        this.userMapper.add(user2);
        System.out.println(user2);
    }

    public Boolean save(User user) {
        int count = this.userMapper.add(user);
        if (count == 1){
            return true;
        }else {
            return false;
        }
    }

    public Boolean editUser(User user) {
       return this.userMapper.edit(user)==1;
    }
}
