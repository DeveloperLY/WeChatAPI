package net.developerly.support.wechat.entity.input;

/**
 * 未知消息
 *
 * @author LY
 * @create 2017/06/01
 **/
public class InputMessageUnknow extends AInputMessage {
    @Override
    public long getCreateTime() {
        return -1;
    }

    @Override
    public String getFromUserName() {
        return "unknow data format";
    }

    @Override
    public String getMsgType() {
        return "unknow data format";
    }

    @Override
    public String getToUserName() {
        return "unknow data format";
    }
}
