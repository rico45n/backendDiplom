package ru.pesnin.system.accounting.integration.dto.user;

public class UserDTO {

    private Integer user_id;

    private String last_name;

    private String first_name;

    private String middle_name;

    private String email;

    private String phone;

    private String user_login;


    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id=" + user_id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", user_login='" + user_login + '\'' +
                '}';
    }
}
