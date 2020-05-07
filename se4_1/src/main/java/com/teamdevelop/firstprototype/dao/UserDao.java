package com.teamdevelop.firstprototype.dao;

import com.teamdevelop.firstprototype.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @classname: UserDao
 * @author : JingYao Deng  & Gongcan Cai
 * @date : 2019/11/4 20:25
 * @description: 用户层的dao接口，继承jpaRepository接口和JpaSpecificationExecutor接口，并且包含了自定义的sql查询语句和对应的返回函数
 */
@Repository
public interface UserDao extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users>
{
    /**
     * 为了防止方法名字无法正确被转换成sql查询语句，可以选择使用原生sql语句查询
     */

    /**从数据库检索对应用户*/
    Users findByUserAccountAndUserPassword( String userAccount, String userPassword );
    Users findByUserAccount(String userAccount);

}
