package Util;

import Domain.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @author SiletFlower
 * @date 2020/12/19 12:14:48
 * @description
 */
public class TokenUtil {
    //token过期时长24小时
    private static final long EXPIRE_TIME = 60 * 60 * 1000 *24;
    //token私钥
    private static final String TOKEN_SECRET = "huajiwuyan";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String createToken(User user) {

        String token = "";
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        Map<String, Object> header = new HashMap();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        token = JWT.create()
                .withHeader(header)
                .withClaim("u_id", user.getU_id())
                .withIssuer("silentflower")
                .withExpiresAt(date)
                .sign(algorithm);
        return token;
    }

    @Test
    public void test(){
        User user = new User();
        user.setU_id(17);
        String token = createToken(user);
        System.out.println(token);
    }

    @Test
    public void test2(){
        String s = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1X2lkIjoxNywiaXNzIjoic2lsZW50Zmxvd2VyIiwiZXhwIjoxNjA4NDM5OTQ1fQ.s3QDRTzJuSMIiMEPjfg0h988qHy-JQQFPgkzfRHewfI";
        Boolean aBoolean = verfiyToken(s);
        System.out.println(aBoolean);
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static Boolean verfiyToken(String token) {
        try {
            if(token == null){
                return false;
            }
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT verify = jwtVerifier.verify(token);
            if(verify.getExpiresAt().getTime() > System.currentTimeMillis() ){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
