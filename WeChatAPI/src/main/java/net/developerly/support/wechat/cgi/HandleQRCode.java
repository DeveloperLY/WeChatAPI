package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.utils.HTTPUtils;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author LY
 * @create 2017/06/03
 **/
public class HandleQRCode {

    /** 通过ticket换取二维码 */
    private static final String URL_GET_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%1$s";

    /** 微信公众号信息 */
    private HandleTicket ticket;

    private HandleQRCode() {

    }

    private HandleQRCode(HandleTicket ticket) {
        this.ticket = ticket;
    }
    /**
     * 获得实例
     * @param ticket
     * @return
     */
    public static HandleQRCode valueOf(HandleTicket ticket) {
        return new HandleQRCode(ticket);
    }

    /**
     * 得到二维码图片
     * @throws WeChatException
     * @throws IOException
     */
    public File getQRCode() throws WeChatException, IOException {
        URLEncoder.encode(this.ticket.getTicket(), "UTF-8");
        String url = integratedURL(URL_GET_QRCODE);
        return HTTPUtils.getOfQRCode(url,ticket.getScene_str());
    }

    /**
     * 格式化 http 地址
     * @param url 待格式化地址
     * @return 格式化后的URL
     * @throws WeChatException
     */
    private String integratedURL(String url) throws WeChatException {
        return String.format(url, ticket.ticket());
    }

}
