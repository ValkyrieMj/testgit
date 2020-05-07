package com.teamdevelop.firstprototype.controller;

import com.teamdevelop.firstprototype.LoginMsg;
import com.teamdevelop.firstprototype.UpdateUser;
import com.teamdevelop.firstprototype.entity.Users;
import com.teamdevelop.firstprototype.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @classname: LoginController
 * @author : JingYao Deng
 * @date : 2019/11/5 14:00
 * @Description: 处理用户登录相关的请求控制类
 */

@RestController
public class UsersController
{

    @Autowired
    UsersService usersService;
    // 设置支持跨域请求
    @CrossOrigin

    @PostMapping( value = "api/login" )
    public LoginMsg Login( @RequestBody Users requestUser )
    {
        String userAccount = requestUser.getUserAccount();

        // 对html标签进行转义，防止XSS攻击
        /// userAccount = HtmlUtils.htmlEscape(userAccount);
        //System.out.println( userAccount );
        return usersService.get( userAccount, requestUser.getUserPassword());

    }

    @PostMapping(value = "api/add")
    public String addNewAccount(@RequestBody Users newAccount)
    {
        return usersService.addNewAccount(newAccount);
    }

    @PostMapping(value = "api/updateUser")
    public String updateAccount(@RequestBody UpdateUser updateAccount)
    {
        return usersService.updatePassword(updateAccount);
//            return "success";
//        else
//            return "password error";
    }

    @PostMapping(value = "api/adminUpdateUser")
    public String adminUpdatePassword(@RequestBody UpdateUser updateAccount)
    {
        return usersService.adminUpdatePassword(updateAccount);
    }

    @PostMapping(value = "api/delete")
    public String deleteAccount(@RequestBody UpdateUser deleteAccount)
    {
        return usersService.deleteAccount(deleteAccount);
    }

    @PostMapping(value = "api/showOne")
    public Users showOne(@RequestBody UpdateUser account)
    {
        return usersService.showOne(account.getAccount());
    }

    @PostMapping(value = "api/showAll")
    public List<Users>showAll()
    {
        return usersService.showAll();
    }

    @PostMapping(value = "api/updateName")
    public String updateName(@RequestBody UpdateUser user)
    {
        return usersService.updateName(user);
    }

}
