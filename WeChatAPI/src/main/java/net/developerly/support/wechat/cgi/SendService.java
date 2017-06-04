package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.entity.output.AOutputMessage;
import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.factory.OutputMessageFactory;
import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.ResultsUtils;

/**
 * 发送客服信息
 *
 * @author LY
 * @create 2017/06/04
 **/
public class SendService {

    /**
     * 获取客服聊天记录接口(此接口为拉取多客服系统里的聊天记录)
     * https://api.weixin.qq.com/cgi-bin/customservice/getrecord?access_token=ACCESS_TOKEN
     */
    /** 发送客服URL */
    private static final String CUSTOM_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%1$s";

    /** 微信公众号信息 */
    private HandleToken token;

    private SendService() {

    }

    private SendService(HandleToken token) {
        this.token = token;
    }
    /**
     * 获得发送客服对像
     * @param token
     * 			微信公众号信息
     * @return
     */
    public static SendService valueOf(final HandleToken token) {
        return new SendService(token);
    }

    /**
     * 发送客服信息
     * @param token
     * 			微信公众号信息
     * @param msg
     * 			发送信息
     * @throws WeChatException
     */
    public static void send(final HandleToken token,final AOutputMessage msg) throws WeChatException {
        valueOf(token).send(msg);
    }

    /**
     * 发送客服信息
     * @param msg
     * 			发送信息
     * @throws WeChatException
     */
    public void send(AOutputMessage msg) throws WeChatException {
        send(OutputMessageFactory.getInstance().toJSON(msg));
    }

    /**
     * 发送客服信息
     * @param jsonStr
     * 			发送内容
     * @throws WeChatException
     */
    private void send(String jsonStr) throws WeChatException {
        String url = String.format(CUSTOM_URL, token.token());
        byte[] datas = HTTPUtils.post(url, jsonStr);
        ResultsUtils.toException(datas);
    }
}
