package br.com.prodemge.DORA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prodemge.DORA.model.AuthRequest;
import br.com.prodemge.DORA.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean authenticate(@RequestBody AuthRequest request) {
        return userService.authenticate(request.getEmail(), request.getPassword());
    }
}
