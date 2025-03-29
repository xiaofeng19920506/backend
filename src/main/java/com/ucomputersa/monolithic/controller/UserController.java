package com.ucomputersa.monolithic.controller;

import com.ucomputersa.monolithic.constant.RoleEnum;
import com.ucomputersa.monolithic.constant.UserConstant;
import com.ucomputersa.monolithic.domain.R;
import com.ucomputersa.monolithic.domain.User;
import com.ucomputersa.monolithic.domain.dto.UserDTO;
import com.ucomputersa.monolithic.service.impl.UserServiceImpl;
import com.ucomputersa.monolithic.utils.AuthenticationUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<R> getUserData(@PathVariable String userId, HttpServletRequest request) {
        String requesterUserId = AuthenticationUtil.getUserId();
        if (!AuthenticationUtil.hasRole(RoleEnum.ADMIN) && !userId.equals(requesterUserId)) {
            throw new AccessDeniedException("Access denied");
        }
        User user = userService.findUserByIdWithValidation(userId);
        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok(R.ok().with("data", userDTO));
    }


}
