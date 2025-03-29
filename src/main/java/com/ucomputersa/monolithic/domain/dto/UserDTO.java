package com.ucomputersa.monolithic.domain.dto;

import com.ucomputersa.monolithic.constant.RoleEnum;
import com.ucomputersa.monolithic.domain.model.Address;
import com.ucomputersa.monolithic.domain.model.Reservation;
import com.ucomputersa.monolithic.domain.model.User;
import com.ucomputersa.monolithic.utils.AuthenticationUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String countryCode;
    private byte[] avatar;
    private List<Address> address;
    private LocalDateTime createAt;
    private LocalDateTime modificationAt;
    private LocalDateTime lastLoginAt;
    private List<Reservation> assignedReservations;
    private List<Reservation> ownedReservations;
    private List<RoleEnum> roles = new ArrayList<>();

    public UserDTO(User user) {
        BeanUtils.copyProperties(user, this);
        if (!AuthenticationUtil.hasRole(RoleEnum.ADMIN)) {
            this.roles = null;
        }
    }
}
