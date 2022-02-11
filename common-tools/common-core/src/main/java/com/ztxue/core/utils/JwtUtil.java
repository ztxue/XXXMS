package com.ztxue.core.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author:sunping
 * @description:token生成工具
 * @date:2020/5/20
 */
@Slf4j
public class JwtUtil {
    protected static String key = "key";

    /**
     * 生成Jwt
     *
     * @param timeMillis 过期时间(毫秒)
     * @param content    内容
     * @param key        加密key
     * @return
     */
    public static String createJwt(long timeMillis, String content, String key) {
        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //私有声明
        Map<String, Object> claims = new HashMap<>(0);
        claims.put("content", content);
        claims.put("key", key);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                //设置JWT的唯一标识
                .setId(UUID.randomUUID().toString().replace("-", ""))
                //签发时间
                .setIssuedAt(now)
                .setSubject(content)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, key);
        if (timeMillis >= 0) {
            long expMillis = nowMillis + timeMillis;
            Date exp = new Date(expMillis);
            //设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }


    /**
     * Token的解密
     *
     * @param token
     * @param key   加密key
     * @return
     */
    public static Claims parseJwt(String token, String key) {

        //得到DefaultJwtParser
        return Jwts.parser()
                //设置签名的秘钥
                .setSigningKey(key)
                //设置需要解析的jwt
                .parseClaimsJws(token).getBody();
    }


    /**
     * 校验token
     *
     * @param token
     * @param key   加密key
     * @return
     */
    public static boolean isVerify(String token, String key) {
        boolean success = false;
        try {
            //得到DefaultJwtParser
            Claims claims = Jwts.parser()
                    //设置签名的秘钥
                    .setSigningKey(key)
                    //设置需要解析的jwt
                    .parseClaimsJws(token).getBody();

            if (claims.get(key).equals(key)) {
                success = true;
            }
        } catch (Exception e) {
            log.error("Jwt校验token异常", e);
        }
        return success;
    }

    public static void main(String[] args) {
        String token = createJwt(60 * 60 * 1000L, "admin", "CHUANGZE@!123");
        isVerify(token, "CHUANGZE@!123");
    }
}
