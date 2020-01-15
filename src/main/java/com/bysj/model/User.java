package com.bysj.model;

import java.util.Date;

/**
 * 用户类
 */
public class User {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phoneNumber;

    public String getDataBirth() {
        return dataBirth;
    }

    public void setDataBirth(String dataBirth) {
        this.dataBirth = dataBirth;
    }

    /**
     * 出生日期
     */
    private String dataBirth;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 邮箱
     */
    private String emialAddress;
    /**
     * 所在地
     */
    private String address;
    /**
     * 头像地址
     */
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmialAddress() {
        return emialAddress;
    }

    public void setEmialAddress(String emialAddress) {
        this.emialAddress = emialAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dataBirth='" + dataBirth + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", emialAddress='" + emialAddress + '\'' +
                ", address='" + address + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
