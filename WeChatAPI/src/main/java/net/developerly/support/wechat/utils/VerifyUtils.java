package net.developerly.support.wechat.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 校验工具类
 *
 * @author LY
 * @create 2017/06/03
 **/
public class VerifyUtils {

    /*
	加密/校验流程如下：
	1. 将token、timestamp、nonce三个参数进行字典序排序
	2. 将三个参数字符串拼接成一个字符串进行sha1加密
	3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	*/
    public static boolean verify(final String signature, final String timestamp, final String nonce, final String token) {
        String sig = signature != null ? signature : "";
        String tim = timestamp != null ? timestamp : "";
        String non = nonce != null ? nonce : "";
        String tok = token != null ? token : "";

        String[] array = {tok, tim, non};
        Arrays.sort(array);

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            buffer.append(array[i]);
        }

        String sha = toSHA(buffer.toString());

        // 与微信传递过来的签名进行比较
        return sha.equalsIgnoreCase(sig);
    }

    private static String toSHA(final String str) {
        return DigestUtils.sha1Hex(str); // 使用commons codec生成sha1字符串
    }
}
