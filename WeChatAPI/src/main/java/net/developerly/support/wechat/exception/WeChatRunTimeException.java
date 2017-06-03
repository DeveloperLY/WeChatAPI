package net.developerly.support.wechat.exception;

/**
 * 微信运行时异常
 *
 * @author LY
 * @create 2017/06/03
 **/
public class WeChatRunTimeException extends RuntimeException {

    public WeChatRunTimeException() {
        super();
    }

    public WeChatRunTimeException(String message) {
        super(message);
    }

}
