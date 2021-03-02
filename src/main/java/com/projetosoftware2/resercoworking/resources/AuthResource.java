package com.projetosoftware2.resercoworking.resources;

import com.projetosoftware2.resercoworking.security.JWTUtil;
import com.projetosoftware2.resercoworking.security.UserSS;
import com.projetosoftware2.resercoworking.services.AuthService;
import com.projetosoftware2.resercoworking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Filipe.Tobias on 07/08/2018.
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @PostMapping(value = "/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response){
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

//    @PostMapping(value = "/forgot")
//    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto){
//        service.sendNewPassword(objDto.getEmail());
//        return ResponseEntity.noContent().build();
//    }
}
