package com.itcast.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(UserMapper.class);
    }

    @Test
    public void test002(){
        System.out.println(this.userMapper.queryUserById(1l));
    }
}
