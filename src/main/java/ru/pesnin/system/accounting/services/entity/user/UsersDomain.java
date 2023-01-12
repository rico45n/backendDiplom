package ru.pesnin.system.accounting.services.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Table(schema = "auth", name = "users")
@Data
public class UsersDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String last_name;

    private String first_name;

    private String middle_name;

    private String email;

    private String phone;

    private String user_login;

    private String user_password;

    private String user_role;


    public UsersDomain() {
    }

    public Integer getUser_id() {
        try {
            return user_id;
        }catch (RuntimeException e) {
            return 0;
        }
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getFioUser(){
        return this.last_name+" "+this.first_name+" "+this.middle_name;
    }

    @Override
    public String toString() {
        return "UsersDomain{" +
                "user_id=" + user_id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", user_login='" + user_login + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_role='" + user_role + '\'' +
                '}';
    }
}
