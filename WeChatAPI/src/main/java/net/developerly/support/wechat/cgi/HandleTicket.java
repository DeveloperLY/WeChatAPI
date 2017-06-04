package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.type.QRCodeType;
import net.developerly.support.wechat.utils.CharsetUtils;
import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.ResultsUtils;

import java.util.Date;

/**
 * @author LY
 * @create 2017/06/03
 **/
public class HandleTicket {
    private static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%1$s";
    /**
     * 该二维码有效时间，以秒为单位。 最大不超过604800（即7天）。
     */
    private long expire_seconds;

    /**
     * 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
     */
    private String action_name;

    /**
     * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     */
    private int scene_id;

    /**
     * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
     */
    private String scene_str;

    private long getTime;

    /**
     * 微信公众号信息
     */
    private HandleToken token;

    /**
     * 换取二维码的Ticket
     */
    private Ticket ticket;

    private HandleTicket(){}

    /**
     * 获得实例
     * @param expire_seconds
     * @param action_name
     * @param scene_id
     * @param scene_str
     * @return
     */
    public static HandleTicket valueOf(HandleToken token, long expire_seconds, String action_name, int scene_id, String scene_str){
        HandleTicket ticket = new HandleTicket();
        ticket.setToken(token);
        ticket.setExpire_seconds(expire_seconds);
        ticket.setAction_name(action_name);
        ticket.setScene_id(scene_id);
        ticket.setScene_str(scene_str);
        return ticket;
    }

    public long getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(long expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public int getScene_id() {
        return scene_id;
    }

    public void setScene_id(int scene_id) {
        this.scene_id = scene_id;
    }

    public String getScene_str() {
        return scene_str;
    }

    public void setScene_str(String scene_str) {
        this.scene_str = scene_str;
    }

    public HandleToken getToken() {
        return token;
    }

    public void setToken(HandleToken token) {
        this.token = token;
    }

    public String ticket() throws WeChatException {
        return ticket == null || isExpires()?getTicket():ticket.getTicket();
    }

    private boolean isExpires(){
        long nowTime = new Date().getTime();
        return nowTime-getTime > ticket.getExpire_seconds()*1000;
    }

    /**
     * 得到换取二维码的Ticket
     * @throws WeChatException
     */
    public String getTicket() throws WeChatException {
        this.getTime = new Date().getTime();
        String sendDatas = getQRSceneJson();
        byte[] datas = HTTPUtils.post(getTicketUrl(), sendDatas.getBytes(CharsetUtils.UTF8));
        this.ticket = ResultsUtils.toTicket(datas);
        return ticket.getTicket();
    }

    /**
     * 得到换取二维码的Ticket的参数JSON
     * @return {"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
     */
    private String getQRSceneJson(){
        StringBuffer sb = new StringBuffer();
        if (this.expire_seconds == -1) {
            sb.append("{'action_name' : ");
            sb.append("'" + this.action_name + "'");
        } else {
            sb.append("{'expire_seconds' : ");
            sb.append(this.expire_seconds);
            sb.append(", 'action_name' : ");
            sb.append("'" + this.action_name + "'");
        }
        sb.append(", 'action_info': {'scene': {");
        if (QRCodeType.valueOf("QR_LIMIT_STR_SCENE").equals(this.action_name) && this.scene_id == 0) {
            sb.append("'scene_str': ");
            sb.append("'" + this.scene_str + "'");
        } else {
            sb.append("'scene_id' : ");
            sb.append(this.scene_id);
        }
        sb.append("}}}");
        return sb.toString().replaceAll("\'", "\"");
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
     * 获取TicketURL
     * @return 格式化后的URL
     * @throws WeChatException
     */
    private String getTicketUrl() throws WeChatException{
        return integratedURL(TICKET_URL);
    }

    public static class Ticket{
        private String ticket;
        private long expire_seconds;
        private String url;

        public Ticket() {
            super();
        }

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public long getExpire_seconds() {
            return expire_seconds;
        }

        public void setExpire_seconds(long expire_seconds) {
            this.expire_seconds = expire_seconds;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
