package com.teamdevelop.firstprototype.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

/**
 * @classname: Users
 * @author : JingYao Deng
 * @date : 2019/10/29 20:02
 * @description: 描述使用者信息的类，这里的使用者定义为普通政府工作人员，只具有查看数据结果的权限
 *               当然这个系统的功能差不多也只有查看数据结果的可视化了
 */

@Entity
@Data
@Table( name = "user" )
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})


public class Users {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    /**
     * 主键
     * */
    @Column( name = "id")
    private int id;

    /**
     * 用户账户
     * */
    @Column( name = "userAccount")
    private String userAccount;

    /**
     * 用户密码
     * */
    @Column( name = "userPassword")
    private String userPassword;

    /**
     * 权限等级
     * */
    @Column( name = "userPriority" )
    private String userPriority;

    @Column(name = "userName")
    private String userName;

}
