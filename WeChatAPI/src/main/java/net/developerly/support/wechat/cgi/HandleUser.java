package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.JsonUtils;
import net.developerly.support.wechat.utils.ResultsUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LY
 * @create 2017/06/03
 **/
public class HandleUser {
    /**
     * 设置备注名
     * http请求方式: POST（请使用https协议）
     * https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN
     * POST数据格式：JSON
     * POST数据例子：
     *{
     *	"openid":"oDF3iY9ffA-hqb2vVvbr7qxf6A0Q",
     *	"remark":"pangzi"
     *}
     *
     *
     *获取用户基本信息（包括UnionID机制）
     *http请求方式: GET
     *https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
     *
     *
     *获取关注者列表
     *http请求方式: GET（请使用https协议）
     *https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
     */

    private static final String USER_REMARK = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=%1$s";

    private static final String USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%1$s&openid=%2$s&lang=zh_CN";

    private static final String USER_GET = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%1$s&next_openid=%2$s";

    private HandleToken token;

    private HandleUser() {

    }

    public static HandleUser valueOf(HandleToken token) {
        HandleUser handle = new HandleUser();
        handle.setToken(token);
        return handle;
    }

    private HandleToken getToken() {
        return token;
    }

    private void setToken(HandleToken token) {
        this.token = token;
    }

    public void createRemarkName(String openid, String remark_name) throws WeChatException {
        String url = String.format(USER_REMARK, getToken().token());
        Map<String , String> dataMap = new HashMap<String, String>();
        dataMap.put("openid", openid);
        dataMap.put("remark", remark_name);
        byte[] datas = HTTPUtils.postOfSSL(url, JsonUtils.toJsonStr(dataMap));
        ResultsUtils.toException(datas);
    }

    public String getCustomerInfo(String openid) throws WeChatException {
        String url = String.format(USER_INFO, getToken().token(), openid);
        byte[] datas = HTTPUtils.getOfSSL(url);
        return ResultsUtils.toDataStr(datas);
    }

    public String findCustomerInfos(String next_openid) throws WeChatException {
        next_openid = next_openid != null ? next_openid : "";
        String url = String.format(USER_GET, getToken().token(), next_openid);
        byte[] datas = HTTPUtils.getOfSSL(url);
        return ResultsUtils.toDataStr(datas);
    }
}
