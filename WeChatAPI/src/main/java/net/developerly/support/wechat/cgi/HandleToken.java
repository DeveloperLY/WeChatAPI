package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.ResultsUtils;

import java.util.Date;

/**
 * 微信公众号信息
 *
 * @author LY
 * @create 2017/06/03
 **/
public class HandleToken {

    private static final String ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token"
            + "?grant_type=client_credential"
            + "&appid=%1$s"
            + "&secret=%2$s";

    private String appid;
    private String secret;
    private long getTime;
    private Token token;

    private HandleToken() {

    }

    public static HandleToken valueOf(String appid, String secret) {
        HandleToken token = new HandleToken();
        token.setAppid(appid);
        token.setSecret(secret);
        return token;
    }

    public String getAppid() {
        return appid;
    }
    public String getSecret() {
        return secret;
    }

    private void setAppid(String appid) {
        this.appid = appid;
    }

    private void setSecret(String secret) {
        this.secret = secret;
    }

    public String token() throws WeChatException {
        return token == null || isExpires() ? getToken() : token.getAccess_token();
    }

    private boolean isExpires() {
        long nowTime = new Date().getTime();
        return nowTime - getTime > token.getExpires_in() * 1000;
    }

    private String getToken() throws WeChatException {
        this.getTime = new Date().getTime();
        String url = String.format(ACCESSTOKEN_URL, this.appid, this.secret);
        byte[] datas = HTTPUtils.get(url);
        this.token = ResultsUtils.toToken(datas);
        return token.getAccess_token();
    }

    public static class Token {

        private String access_token = "";
        private Integer expires_in;

        public Token() {
            super();
        }

        public String getAccess_token() {
            return access_token;
        }
        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }
        public Integer getExpires_in() {
            return expires_in;
        }
        public void setExpires_in(Integer expires_in) {
            this.expires_in = expires_in;
        }
    }
}
