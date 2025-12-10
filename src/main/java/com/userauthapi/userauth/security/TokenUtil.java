package com.userauthapi.userauth.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Collections;

public class TokenUtil {

    public static Authentication decode(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        System.out.println("Request header: "+header);
        if (header != null){
            String token = header.replace("Bearer ", "");
            if (token.equals("security123")){
                System.out.println("Meu token tratado: "+token);
                return new UsernamePasswordAuthenticationToken("valido", null, Collections.emptyList());
            }
        }
        return null;
    }
}
