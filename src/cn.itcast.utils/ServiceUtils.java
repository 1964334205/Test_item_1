package cn.itcast.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
//将数据转换成md5格式
public class ServiceUtils {
    public static String md5(String message){
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(message.getBytes());

            Base64.Encoder base64 =  Base64.getEncoder();
            return base64.encodeToString(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
