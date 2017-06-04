package net.developerly.support.wechat.cgi.web;

import net.developerly.support.wechat.cgi.HandleToken;
import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.ResultsUtils;

/**
 * 用户授权
 *
 * @author LY
 * @create 2017/06/03
 **/
public class UserToken {
    private static final String CODE_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=%1$s&redirect_uri=%2$s&response_type=code&scope=%3$s&state=%4$s#wechat_redirect";
    private static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%1$s&secret=%2$s&code=%3$s&grant_type=authorization_code";
//	private static final String REFRESH_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%1$s&grant_type=refresh_token&refresh_token=%2$s";
//	private static final String USER_INFO_URL="https://api.weixin.qq.com/sns/userinfo?access_token=%1$s&openid=%2$s&lang=zh_CN";
//	private static final String VERIFY_URL="https://api.weixin.qq.com/sns/auth?access_token=%1$s&openid=%1$s";

    private HandleToken handleToken;

    private Token token;

    private UserToken() {

    }

    private UserToken(HandleToken token) {
        this.handleToken = token;
    }

    public static UserToken valueOf(HandleToken token) {
        return new UserToken(token);
    }

    public static String getCodeUrlOfBase(HandleToken token, String redirect_uri) {
        return valueOf(token).getCodeUrlOfBase(redirect_uri);
    }

    public static String getCodeUrlOfUserInfo(HandleToken token, String redirect_uri) {
        return valueOf(token).getCodeUrlOfUserInfo(redirect_uri);
    }

    public static String getTokenUrl(HandleToken token, String code) {
        return valueOf(token).getTokenUrl(code);
    }

    public static String token(HandleToken token, String code) throws WeChatException {
        return valueOf(token).getToken(code).getAccess_token();
    }

    public static String getOpenId(HandleToken token, String code)throws WeChatException {
        return valueOf(token).getOpenId(code);
    }

    public String getCodeUrlOfBase(String redirect_uri) {
        return getCodeUrlOfBase(handleToken.getAppid(), redirect_uri);
    }

    public String getCodeUrlOfUserInfo(String redirect_uri) {
        return getCodeUrlOfUserInfo(handleToken.getAppid(), redirect_uri);
    }


    public String getTokenUrl(String code) {
        return getTokenUrl(handleToken.getAppid(), handleToken.getSecret(), code);
    }

	/*
	private String getRefreshUrl() {
		return getRefreshUrl(handleToken.getAppid(), token.getRefresh_token());
	}

	private String getUserInfoUrl() {
		return getUserInfoUrl(handleToken.getAppid(), token.getOpenid());
	}

	private String getVerifyUrl() {
		return getVerifyUrl(token.getAccess_token(), token.getOpenid());
	}
	*/


    private Token getToken(String code) throws WeChatException {
        String url = getTokenUrl(code);

        byte[] datas = HTTPUtils.getOfSSL(url);
        token = ResultsUtils.toUserToken(datas);
        return token;
    }

    public String getOpenId(String code) throws WeChatException {
        token = getToken(code);
        return token.getOpenid();
    }


	/*
	public String refresh() {
		// TODO 此处需做逻辑判断
		return token.getAccess_token();
	}*/





    private String getTokenUrl(String appid, String secret, String code) {
        return String.format(ACCESS_TOKEN_URL, appid, secret, code);
    }
    /*
    private String getRefreshUrl(String appid, String refresh_token) {
        return String.format(REFRESH_TOKEN_URL, appid, refresh_token);
    }

    private String getUserInfoUrl(String access_token, String openid) {
        return String.format(USER_INFO_URL, access_token,openid);
    }

    private String getVerifyUrl(String access_token, String openid) {
        return String.format(VERIFY_URL, access_token, openid);
    }
    */
    private String getCodeUrl(String appid, String redirect_uri, Scope scope, State state) {
        return String.format(CODE_URL, appid, redirect_uri, scope.name(), state.name());
    }

    private String getCodeUrlOfBase(String appid, String redirect_uri) {
        return getCodeUrl(appid, redirect_uri, Scope.snsapi_base, State.success);
    }

    private String getCodeUrlOfUserInfo(String appid, String redirect_uri) {
        return getCodeUrl(appid, redirect_uri, Scope.snsapi_userinfo, State.success);
    }


    public static class Token {
        private String access_token;
        private String expires_in;
        private String refresh_token;
        private String openid;
        private String scope;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(String expires_in) {
            this.expires_in = expires_in;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }
    }

    public enum Scope {
        snsapi_base,
        snsapi_userinfo;
    }

    public enum State {
        success;
    }
}
