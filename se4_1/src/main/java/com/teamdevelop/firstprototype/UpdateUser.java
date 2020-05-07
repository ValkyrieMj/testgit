package com.teamdevelop.firstprototype;

import lombok.Data;

@Data
public class UpdateUser {
    String priority;
    String account;
    String oldPassword;
    String newPassword;
    String name;
}
