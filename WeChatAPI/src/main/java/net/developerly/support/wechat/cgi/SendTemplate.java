package net.developerly.support.wechat.cgi;

/**
 * @author LY
 * @create 2017/06/03
 **/
// TODO 此类未进行实现，因参数不明
public class SendTemplate {
    /**
     * https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
     */
    private static final String TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%1$s";

    private String access_token;
    private String template_id;

    private SendTemplate() {
        super();
    }

    private SendTemplate(String access_token, String template_id) {
        super();
        this.access_token = access_token;
        this.template_id = template_id;
    }
    public static SendTemplate valueOf(final String access_token, final String template_id) {
        SendTemplate template = new SendTemplate(access_token,template_id);
        return template;
    }

    private String templateURL() {
        return String.format(TEMPLATE_URL, access_token);
    }

    public void send(String openid) {

    }



}