package com.atguigu.commonutils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author lxy
 * @since 2021-06-09
 */
public class JwtUtils {

    /**
     * token过期时间
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    /**
     * 秘钥
     */
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 生成token字符串的方法
     *
     * @param id       用户id
     * @param nickname 用户名
     * @return
     */
    public static String getJwtToken(String id, String nickname) {
        String jwtToken = Jwts.builder()
                //jwt第一部分:header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //jwt过期时间
                .setSubject("guli-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //jwt第二部分:主题部分
                .claim("id", id)  //设置token主体部分 ，存储用户信息
                .claim("nickname", nickname)
                //jwt第三部分：签名hash
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        return jwtToken;
    }

    /**
     * 判断token是否存在并有效
     *
     * @param jwtToken token
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken))
            return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在并有效
     *
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken))
                return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token字符串获取用户id
     *
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(jwtToken))
            return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("id");
    }
}
