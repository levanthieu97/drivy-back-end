package com.thieu.setup.security;

import io.jsonwebtoken.*;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;


@Component
public class JwtTokenProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);
    private static final String jwtSecret = new BigInteger(130, new SecureRandom()).toString(32);

    @Value("${jwt.expire.hours}")
    private int jwtExpireHrs;

    public String generateToken(JwtUser jwtUser){
        Date expireDate = new DateTime().plusHours(jwtExpireHrs).toDate();
        return Jwts.builder()
                .setId(Integer.toString(jwtUser.getUserId()))
                .setSubject(jwtUser.getUsername())
                .claim("email",jwtUser.getEmail())
                .claim("phone",jwtUser.getPhone())
                .claim("address",jwtUser.getAddress())
                .claim("auth", jwtUser.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getJwtUser(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

//    public int getUserIdFromJwt(String token){
//        Claims claims = Jwts.parser()
//                .setSigningKey(jwtSecret)
//                .parseClaimsJws(token)
//                .getBody();
//        return Integer.parseInt(claims.getSubject());
//    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT claims string is empty.");
        }
        return false;
    }


    public String generatePassword(String originalPassword) {
        return BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
    }

    public boolean validatePassword(String originalPassword, String dbPassword){
        try{
            return BCrypt.checkpw(originalPassword, dbPassword);
        }
        catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        return false;
    }

}
