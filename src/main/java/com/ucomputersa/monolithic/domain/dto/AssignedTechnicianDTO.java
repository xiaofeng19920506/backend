package com.ucomputersa.monolithic.domain.dto;

import lombok.Data;

@Data
public class AssignedTechnicianDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String countryCode;
}
