package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.cgi.bean.WeChatMenu;
import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.utils.CharsetUtils;
import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.JsonUtils;
import net.developerly.support.wechat.utils.ResultsUtils;

/**
 * 自定义微信菜单
 *
 * @author LY
 * @create 2017/06/03
 **/
public class HandleMenu {

    /** 自定义菜单创建接口 */
    private static final String URL_CREATE_MENU     = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%1$s";
    /** 自定义菜单查询接口 */
    private static final String URL_QUERY_MENU      = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%1$s";
    /** 删除自定义菜单 */
    private static final String URL_DELETE_MENU     = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%1$s";

    /**微信公众号信息*/
    private HandleToken token;

    private HandleMenu() {

    }

    private HandleMenu(HandleToken token) {
        this.token = token;
    }

    /**
     * 获得实例
     * @param token
     * @return
     */
    public static HandleMenu valueOf(final HandleToken token) {
        return new HandleMenu(token);
    }

    /**
     * 创建菜单
     * @param token
     * 			微信公众号信息
     * @param menu
     * 			微信自定菜单
     * @throws WeChatException
     */
    public static void create(HandleToken token, WeChatMenu menu) throws WeChatException {
        valueOf(token).create(menu);
    }

    /**
     * 查询菜单
     * @param token
     * @throws WeChatException
     */
    public static String find(HandleToken token) throws WeChatException {
        return valueOf(token).find();
    }

    /**
     * 删除菜单
     * @param token
     * @throws WeChatException
     */
    public static void delete(HandleToken token)throws WeChatException {
        valueOf(token).delete();
    }

    /**
     * 格式化 http 地址
     * @param url 待格式化地址
     * @return 格式化后的URL
     * @throws WeChatException
     */
    private String integratedURL(String url) throws WeChatException {
        return String.format(url, token.token());
    }

    /**
     * 新增菜单URL
     * @return 格式化后的URL
     * @throws WeChatException
     */
    private String getCreateUrl() throws WeChatException {
        return integratedURL(URL_CREATE_MENU);
    }

    /**
     * 删除菜单URL
     * @return 格式化后的URL
     * @throws WeChatException
     */
    private String getDeleteUrl() throws WeChatException {
        return integratedURL(URL_DELETE_MENU);
    }

    /**
     * 查询菜单URL
     * @return 格式化后的URL
     * @throws WeChatException
     */
    private String getQueryUrl() throws WeChatException {
        return integratedURL(URL_QUERY_MENU);
    }

    /**
     * 创建新菜单
     * @param menuStr 菜单JSON字符串
     * @throws WeChatException
     */
    @Deprecated
    protected void create(String menuStr) throws WeChatException {
        byte[] datas = HTTPUtils.post(getCreateUrl(), menuStr.getBytes(CharsetUtils.UTF8));
        ResultsUtils.toException(datas);
    }

    /**
     * 创建新菜单
     * @param menu
     * 			微信菜单
     * @throws WeChatException
     */
    public void create(WeChatMenu menu) throws WeChatException {
        String sendDatas = JsonUtils.toJsonStr(menu);
        byte[] datas = HTTPUtils.post(getCreateUrl(), sendDatas.getBytes(CharsetUtils.UTF8));
        ResultsUtils.toException(datas);
    }

    /**
     * 删除当前微信公众号使用的菜单
     * @throws WeChatException
     */
    public void delete() throws WeChatException {
        byte[] datas = HTTPUtils.get(getDeleteUrl());
        ResultsUtils.toException(datas);
    }

    /**
     * 查询当前微信公众号使用的菜单
     * @return
     * @throws WeChatException
     */
    public String find() throws WeChatException {
        byte[] datas = HTTPUtils.get(getQueryUrl());
        return ResultsUtils.toDataStr(datas);
    }

}
