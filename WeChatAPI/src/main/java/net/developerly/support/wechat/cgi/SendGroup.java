package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.JsonUtils;
import net.developerly.support.wechat.utils.ResultsUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 群发信息
 * 订阅号：1条/天
 * 服务号：4条/月
 * 企业号：待定
 * 此实现类接口，需在公众号上进行测试 ，特别是按OpenID 发送消息时
 *
 * @author LY
 * @create 2017/06/03
 **/
public class SendGroup {

    /**
     * https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN
     * https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN
     * https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN
     */
    private static final String SEND_GROUPID    = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=%1$s";
    private static final String SEND_OPENID     = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=%1$s";
    private static final String DELETE          = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=%1$s";

    private String access_token;

    private SendGroup() {
        super();
    }

    private SendGroup(String access_token) {
        super();
        this.access_token = access_token;
    }

    public static SendGroup valueOf(final String access_token) {
        return new SendGroup(access_token);
    }

    /**
     * 格式化 http 地址
     * @param url 待格式化地址
     * @return 格式化后的URL
     */
    private String integratedURL(String url) {
        return String.format(url,access_token);
    }

    private String getSendGroupIDUrl() {
        return integratedURL(SEND_GROUPID);
    }

    private String getSendOpenIDUrl() {
        return integratedURL(SEND_OPENID);
    }

    private String getDeleteUrl() {
        return integratedURL(DELETE);
    }

    /**
     * 删除群发信息
     * 注意：
     * 		只有已经发送成功的消息才能删除删除消息只是将消息的图文详情页失效，
     * 已经收到的用户，还是能在其本地看到消息卡片。 另外，删除群发消息只能删除图
     * 文消息和视频消息，其他类型的消息一经发送，无法删除。
     * @param messageID 消息 id
     * @throws WeChatException
     */
    public void delete(String messageID) throws WeChatException {
        Map<String, String> out = new HashMap<String, String>();
        out.put("msg_id", messageID);
        byte[] datas = HTTPUtils.post(getDeleteUrl(), JsonUtils.toJsonStr(out));
        ResultsUtils.toException(datas);
    }

    public void sendByGroupID(String group_id,String content,MessageType type) throws WeChatException {
        String jsonStr = JsonUtils.toJsonStr(createTemplate(group_id, content, type));
        byte[] datas = HTTPUtils.postOfSSL(getSendGroupIDUrl(), jsonStr);
        ResultsUtils.toException(datas);
    }

    public void sendByOpenID(String open_id, String content, MessageType type) throws WeChatException {
        List<String> openIDs = new ArrayList<String>();
        openIDs.add(open_id);
        sendByOpenID(openIDs,content,type);
    }

    public void sendByOpenID(List<String> open_ids, String content, MessageType type) throws WeChatException {
        String jsonStr = JsonUtils.toJsonStr(createTemplate(open_ids, content, type));
        byte[] datas = HTTPUtils.postOfSSL(getSendOpenIDUrl(), jsonStr);
        ResultsUtils.toException(datas);
    }

    private Map<String, Object> createTemplate(String id, String content, MessageType type) {
        Map<String, Object> template = new HashMap<String, Object>();
        template.put("msgtype", type.name().toLowerCase());
        template.put("filter", createFilter(id));
        template.put(type.name().toLowerCase(), createContent(content, type));
        return template;
    }

    private Map<String, Object> createTemplate(List<String> ids,String content,MessageType type) {
        Map<String, Object> template = new HashMap<String, Object>();
        template.put("msgtype", type.name().toLowerCase());
        template.put("filter", createFilter(ids));
        template.put(type.name().toLowerCase(), createContent(content, type));
        return template;
    }

    private Map<String,String> createContent(String content, MessageType type) {
        Map<String, String> msg = new HashMap<String, String>();
        msg.put(type == MessageType.TEXT ? "content" : "media_id", content);
        return msg;
    }

    private Map<String,String> createFilter(String toGroup) {
        Map<String, String> filter = new HashMap<String, String>();
        filter.put("group_id", toGroup);
        return filter;
    }

    private Map<String,Object> createFilter(List<String> toUser) {
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("touser", toUser);
        return filter;
    }


    public enum MessageType {
        MPNEWS(),
        TEXT(),
        VOICE(),
        IMAGE(),
        MPVIDEO(),
        VIDEO();
    }
}
