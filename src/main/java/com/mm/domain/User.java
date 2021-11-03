package com.mm.domain;

public class User {
    private Integer userId;
    private String userName;
    private String realName;
    private String password;
    private String phone;
    private String email;
    private String address;
    private String isDelete;


    public User() {
    }

    public User(Integer userId, String userName, String realName, String password, String phone, String email,String address,String isDelete) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address=address;
        this.isDelete=isDelete;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}
