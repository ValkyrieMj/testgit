package com.teamdevelop.firstprototype;

import lombok.Data;

@Data
public class UpdatePassword {
    String accout;
    String oldPassword;
    String newPassword;
}
