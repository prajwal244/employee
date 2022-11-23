package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.JwtRequest;
import com.employee.entity.JwtResponse;
import com.employee.service.JwtService;

@RestController
public class JwtController {

	
	 @Autowired
	    private JwtService jwtService;

	    @PostMapping({"/authenticate"})
	    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	        return jwtService.createJwtToken(jwtRequest);
	    }
	}

