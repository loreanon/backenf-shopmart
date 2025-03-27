package com.avanthi.eshop.rest.api.service.impl;

import com.avanthi.eshop.rest.api.entity.Role;
import com.avanthi.eshop.rest.api.entity.User;
import com.avanthi.eshop.rest.api.payload.LoginDto;
import com.avanthi.eshop.rest.api.payload.RegisterDto;
import com.avanthi.eshop.rest.api.repository.RoleRepository;
import com.avanthi.eshop.rest.api.repository.UserRepository;
import com.avanthi.eshop.rest.api.security.JwtTokenProvider;
import com.avanthi.eshop.rest.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private AuthenticationManager authenticationManager;
@Autowired
private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println("Token generated: " + token);

        return "{\"token\":\"" + token + "\"}";
    }

    @Override
    public String register(RegisterDto registerDto) {
        if(userRepository.existsByUsername(registerDto.getUsername())){
            return "Username is already taken!";
        }

        // check for email exist in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            return "Email is already taken!";
        }

        // create new user
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // assign role to user
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("ADMIN").get();
        roles.add(role);
        user.setRoles(roles);

        // save user
        userRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public String createRole(Role role) {
        return "";
    }

    @Override
    public String deleteRole(String name) {
        return "";
    }

    @Override
    public List<Role> getAllRoles() {
        return List.of();
    }

    @Override
    public String getRoleByName(String name) {
        return "";
    }
}
