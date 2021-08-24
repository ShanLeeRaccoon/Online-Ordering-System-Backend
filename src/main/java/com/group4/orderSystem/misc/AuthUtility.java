package com.group4.orderSystem.misc;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class AuthUtility {
    public final int TOKEN_EXPIRATION_DURATION = 1000000000;
    private final String SECRET = "WHYAREWEDOINGTHISTOOURSELVES";
    public String getSecretString(){
        //        Dotenv dotenv = Dotenv.load();
//        String secret = dotenv.get("SECRET");
        return this.SECRET;
    }

    public DecodedJWT getDecodedJWT(String authorizationHeader){
        String secret = getSecretString();
        String token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT;
    }

    public static void getAuthException(HttpServletResponse response, Exception exception) throws IOException {
        response.setHeader("error", exception.getMessage());
        response.setStatus(FORBIDDEN.value());
        Map<String, String> error = new HashMap<>();
        error.put("error_msg", exception.getMessage());
        response.setContentType(APPLICATION_JSON_VALUE);

        new ObjectMapper().writeValue(response.getOutputStream(), error);
    }
}
