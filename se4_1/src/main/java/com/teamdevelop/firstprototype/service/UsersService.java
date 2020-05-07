package com.teamdevelop.firstprototype.service;

import com.teamdevelop.firstprototype.LoginMsg;
import com.teamdevelop.firstprototype.UpdateUser;
import com.teamdevelop.firstprototype.dao.UserDao;
import com.teamdevelop.firstprototype.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @classname: UsersService
 * @author : JingYao Deng  & Gongcan Cai
 * @date : 2019/11/4 20:42
 * @Functionality: user类的服务，用于登录验证和与账户有关的其他操作
 */
@Service
public class UsersService
{
    @Autowired
    UserDao userDao;

    public LoginMsg get(String userAccount, String userPassword )
    {
        LoginMsg ans = new LoginMsg();
        Users user2 = userDao.findByUserAccountAndUserPassword( userAccount, userPassword );
        Users user1 = userDao.findByUserAccount(userAccount);
        //System.out.println(user1);
//        System.out.println(userPassword);

        if ( user1 == null )
            ans.setMsg( "No account" );
        else if (user2 == null )
            ans.setMsg("Password error");
        else
            {
            ans.setMsg("Success");
            ans.setAccount(user2.getUserAccount());
            ans.setPriority(user2.getUserPriority());
            ans.setCode( 1 );
        }
        return ans;
    }

    public String addNewAccount( Users newAccount )
    {
        if (userDao.findByUserAccount(newAccount.getUserAccount()) != null)
            return "account error";
        userDao.saveAndFlush(newAccount);
        return "success";
    }

    public String updatePassword(UpdateUser updateAccount)
    {
        Users account = userDao.findByUserAccount( updateAccount.getAccount() );
//        System.out.println(updateAccount.getOldPassword());
//        System.out.println(updateAccount.getNewPassword());
//        System.out.println(updateAccount.getAccount());
        if (account.getUserPassword().equals(updateAccount.getOldPassword()))
        {
            account.setUserPassword(updateAccount.getNewPassword());
//            System.out.println(account.getUserPassword());
            userDao.saveAndFlush(account);
            return "success";
        }
        else
            return "password error";
    }

    public String adminUpdatePassword(UpdateUser updateAccount)
    {
        if (updateAccount.getPriority().equals("管理员"))
            return "priority error";
        Users account = userDao.findByUserAccount(updateAccount.getAccount());
        account.setUserPassword(updateAccount.getNewPassword());
        userDao.saveAndFlush(account);
        return "success";
    }

    public String deleteAccount(UpdateUser deleteAccount)
    {
        Users user = userDao.findByUserAccount(deleteAccount.getAccount());
        if (deleteAccount.getPriority().equals("管理员"))
            return "priority error";
        if (user == null)
            return "account error";
        else {
            userDao.delete(user);
            return "success";
        }
    }

    public Users showOne(String account)
    {
        return userDao.findByUserAccount(account);
    }

    public List<Users> showAll()
    {
        return userDao.findAll();
    }

    public String updateName(UpdateUser user)
    {
        Users u = userDao.findByUserAccount(user.getAccount());
        if (u == null)
            return "account error";
        u.setUserName(user.getName());
        userDao.saveAndFlush(u);
        return "success";
    }
}
