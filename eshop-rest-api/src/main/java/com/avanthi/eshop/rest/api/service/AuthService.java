package com.avanthi.eshop.rest.api.service;

import com.avanthi.eshop.rest.api.entity.Role;
import com.avanthi.eshop.rest.api.payload.LoginDto;
import com.avanthi.eshop.rest.api.payload.RegisterDto;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String createRole(Role role);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);

}