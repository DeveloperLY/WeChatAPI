package net.developerly.support.wechat.exception;

/**
 * 微信错误异常
 *
 * @author LY
 * @create 2017/06/03
 **/
public class WeChatException extends Exception {

    private String code;
    private String message;

    public WeChatException() {
        super();
    }

    public WeChatException(String code, String message) {
        super(code+"."+message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code+"."+message;
    }
}
