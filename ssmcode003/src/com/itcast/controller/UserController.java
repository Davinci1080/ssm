package com.itcast.controller;

import com.itcast.pojo.User;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

 /*   @RequestMapping("users")
    public String toUser(){
        return "users";
    }
*/
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryUserAll(){
        Map<String,Object> map = new HashMap<>();
        //查询总条数
        Long total = this.userService.queryTotal();
        map.put("total",total);
        //查询用户列表List<User>
        List<User> list = this.userService.queryUserAll();
        map.put("rows",list);
        return map;
    }
    /*@RequestMapping("page/add")
    public String toUserAdd(){
        return "user-add";
    }*/

    @RequestMapping("save")
    @ResponseBody
    public Map<String,String> saveUser(User user){
        Map<String,String> map = new HashMap<>();

       /* if (result.hasErrors()){
            System.out.println(result.getAllErrors());
            map.put("status","200");
            return map;
        }*/
        Boolean flag = this.userService.save(user);
        if (flag) {
            map.put("status","200");
        } else {
            map.put("status","500");
        }

        return map;
    }
    @RequestMapping("edit")
    @ResponseBody
    public Map<String, String> editUser(User user) {

        Map<String, String> map = new HashMap<>();

        /*if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            map.put("status", "500");
            return map;
        }*/

        // 调用service方法新增用户信息
        Boolean flag = this.userService.editUser(user);
        if (flag) {
            // 成功，put200
            map.put("status", "200");
        } else {
            // 失败，put500
            map.put("status", "500");
        }
        return map;
    }
}

