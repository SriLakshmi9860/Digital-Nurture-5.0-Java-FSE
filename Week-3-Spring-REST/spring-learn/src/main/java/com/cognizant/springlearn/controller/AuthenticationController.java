package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.AuthenticationRequest;
import com.cognizant.springlearn.model.AuthenticationResponse;
import com.cognizant.springlearn.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest request) {

        String token = jwtUtil.generateToken(request.getUsername());

        return new AuthenticationResponse(token);
    }
}