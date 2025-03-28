package com.ucomputersa.monolithic.domain.dto;


import lombok.Data;

@Data
public class RegisterRequestDTO {


    String lastName;
    String firstName;
    String password;
    String email;
    String phoneNumber;
    String countryCode;

}
