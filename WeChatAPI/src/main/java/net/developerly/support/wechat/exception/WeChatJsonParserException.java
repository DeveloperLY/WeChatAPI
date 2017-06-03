package net.developerly.support.wechat.exception;

/**
 * 微信从JSON反序列化异常
 *
 * @author LY
 * @create 2017/06/03
 **/
public class WeChatJsonParserException extends WeChatException {

    public WeChatJsonParserException() {
        super("-10001", "JSON 数据有误，请确认后再重新解释！");
    }

    public WeChatJsonParserException(String code, String message) {
        super(code, message);
    }

}
