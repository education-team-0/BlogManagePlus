package com.whu.controller;

import com.whu.annotation.PassToken;
import com.whu.annotation.UserLoginToken;
import com.whu.entity.Response;
import com.whu.entity.User;
import com.whu.service.TokenService;
import com.whu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-10-21 10:24
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;



    @RequestMapping(value = "/find/all" )
    public Response findAll(){
        List<User> userList= userService.findAll();
        return new Response().success(userList);
    }


    @RequestMapping("/find/{id}")
    public Response findById(@PathVariable(name = "id") int id){
        User user= userService.findById(id);
        return new Response().success(user);
    }

    @RequestMapping("/addbyattri")
    public Response addUserByAttri(String name,String pwd){
        User user=new User(name,pwd);
        String status= userService.addUser(user);
        return new Response().success(status);
    }


    @RequestMapping(value = "/add" )
    public Response addUser(@RequestBody User user){

        String status= userService.addUser(user);
        return new Response().success(status);
    }

    @GetMapping("/login")
    public Response login(@RequestParam("name") String username,
                          @RequestParam("pass") String password) {
        User user= userService.findByName(username);
        if(user!=null){
            if(user.getPwd().equals(password)){
                //登录成功则生成token并返回
                String token=tokenService.getToken(user);
                return new Response().success(token);
            }else{
                return new Response().failure("密码不正确!");
            }
        }
        else{
            return new Response().failure("用户名不存在!");
        }
    }



    @UserLoginToken
    @GetMapping("/logintoken")
    public String loginToken(){
        return "UserLoginToken!";
    }

    @PassToken
    @GetMapping("/passtoken")
    public String passToken(){
        return "PassToken!";
    }


}
