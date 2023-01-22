package ru.pesnin.system.accounting.services.entity.user;

import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Table(schema = "auth", name = "users")
@Data
@NoArgsConstructor
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "user_login")
    private String userLogin;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_role")
    private String userRole;


    public String getFioUser(){
        return this.lastName+" "+this.firstName+" "+this.middleName;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "userId=" + userId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
