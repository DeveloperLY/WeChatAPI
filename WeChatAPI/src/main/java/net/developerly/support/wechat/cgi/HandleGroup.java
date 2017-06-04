package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.JsonUtils;
import net.developerly.support.wechat.utils.ResultsUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理公众号用户分组
 *
 * @author LY
 * @create 2017/06/03
 **/
public class HandleGroup {

    /**
     * 创建公众号分组
     * POST:{"group":{"name":"test"}}
     * */
    private static final String GROUP_CREATE="https://api.weixin.qq.com/cgi-bin/groups/create?access_token=%1$s";

    /**
     * 查询所有分组
     */
    private static final String GROUP_GET="https://api.weixin.qq.com/cgi-bin/groups/get?access_token=%1$s";

    /**
     * 查询用户所在分组
     * POST:{"openid":"od8XIjsmk6QdVTETa9jLtGWA6KBc"}
     */
    private static final String GROUP_GET_ID="https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=%1$s";

    /**
     * 修改分组名
     * POST:{"group":{"id":108,"name":"test2_modify2"}}
     */
    private static final String GROUP_UPDATE="https://api.weixin.qq.com/cgi-bin/groups/update?access_token=%1$s";

    /**
     * 移动用户分组
     * POST:{"openid":"oDF3iYx0ro3_7jD4HFRDfrjdCM58","to_groupid":108}
     */
    private static final String GROUP_USER_UPDATE="https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=%1$s";

    private String access_token;

    private HandleGroup() {
        super();
    }

    private HandleGroup(String access_token) {
        super();
        this.access_token = access_token;
    }

    /**
     * 获得HandleGroup实例
     * @param access_token
     * 			公众号令牌
     * @return
     */
    public static HandleGroup valueOf(final String access_token) {
        return new HandleGroup(access_token);
    }

    /**
     * 格式化 http 地址
     * @param url 待格式化地址
     * @return 格式化后的URL
     */
    private String integratedURL(String url) {
        return String.format(url, access_token);
    }

    /**
     * 获得创建分组URL
     * @return
     */
    private String getCreateGroupUrl() {
        return integratedURL(GROUP_CREATE);
    }

    /**
     * 获得查询分组URL
     * @return
     */
    private String getQueryGroupAllUrl() {
        return integratedURL(GROUP_GET);
    }

    /**
     * 获得查询用户所在分组URL
     * @return
     */
    private String getQueryGroupOpenIDUrl() {
        return integratedURL(GROUP_GET_ID);
    }

    /**
     * 获得更新分组URL
     * @return
     */
    private String getUpdateGroupUrl() {
        return integratedURL(GROUP_UPDATE);
    }

    /**
     * 获得移动用户URL
     * @return
     */
    private String getUpdateUserUrl() {
        return integratedURL(GROUP_USER_UPDATE);
    }

    /**
     * 创建分组
     * @param group_name
     * 			分组名称
     * @return
     * 			Json 格式的分组令牌
     * @throws WeChatException
     * 			微信返回错误信息
     */
    public String createGroup(String group_name) throws WeChatException {
        Map<String, Map<String, String>> groups = new HashMap<String, Map<String, String>>();
        Map<String, String> name = new HashMap<String, String>();
        name.put("name", group_name);
        groups.put("group", name);
        byte[] datas = HTTPUtils.postOfSSL(getCreateGroupUrl(), JsonUtils.toJsonStr(groups));
        return ResultsUtils.toDataStr(datas);
    }

    /**
     * 更新分组信息
     * @param group_id
     * 			分组 id ,通过查询分组获得
     * @param group_name
     * 			分组名称
     * @throws WeChatException
     * 			微信返回错误信息
     */
    public void updateGroup(String group_id,String group_name) throws WeChatException {
        Map<String,Object> groups = new HashMap<String, Object>();
        Map<String, String> group = new HashMap<String, String>();
        group.put("id", group_id);
        group.put("name", group_name);
        groups.put("group", group);
        byte[] datas = HTTPUtils.postOfSSL(getUpdateGroupUrl(), JsonUtils.toJsonStr(groups));
        ResultsUtils.toException(datas);
    }

    /**
     * 查询所有分组
     * @return
     * @throws WeChatException
     */
    public String findGroups() throws WeChatException {
        byte[] datas = HTTPUtils.getOfSSL(getQueryGroupAllUrl());
        return ResultsUtils.toDataStr(datas);
    }

    /**
     * 查询用户所在分组
     * @param open_id
     * 			用户ID
     * @return
     * @throws WeChatException
     */
    public String findGroupsByOpenID(String open_id) throws WeChatException {
        Map<String, String> id = new HashMap<String, String>();
        id.put("openid", open_id);
        byte[] datas=HTTPUtils.postOfSSL(getQueryGroupOpenIDUrl(), JsonUtils.toJsonStr(id));
        return ResultsUtils.toDataStr(datas);
    }
    /**
     * 移动用户
     * @param open_id
     * 			用户ID
     * @param group_id
     * 			分组ID
     * @throws WeChatException
     */
    public void moveUser(String open_id,String group_id) throws WeChatException {
        Map<String, String> move = new HashMap<String, String>();
        move.put("openid", open_id);
        move.put("to_groupid", group_id);
        byte[] datas = HTTPUtils.postOfSSL(getUpdateUserUrl(), JsonUtils.toJsonStr(move));
        ResultsUtils.toException(datas);
    }
}
