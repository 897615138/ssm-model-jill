package jill.entity;

import lombok.Data;

@Data
public class UserInfo {
    private String userId;
    private String userName;
    private String userNickname;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userAvatar;
    private byte userSex;
    private byte userDelete;
}
