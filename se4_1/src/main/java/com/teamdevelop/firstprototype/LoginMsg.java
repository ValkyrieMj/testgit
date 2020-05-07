package com.teamdevelop.firstprototype;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@Data
public class LoginMsg {
    String account;
    String priority;
    String msg;
    int code;

    public LoginMsg()
    {
        msg = null;
        priority = null;
        account = null;
        code = 0;
    }
}
