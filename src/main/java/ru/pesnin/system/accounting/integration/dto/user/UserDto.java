package ru.pesnin.system.accounting.integration.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer userId;

    private String lastName;

    private String firstName;

    private String middleName;
    private String email;
    private String phone;

    private String userLogin;

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }
}
