package net.developerly.support.wechat.entity;

/**
 * 微信消息基础类
 *
 * @author LY
 * @create 2017/06/01
 **/
public class AMessage {
    /**
     * 开发者微信号
     */
    private String toUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    private String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    private long createTime;

    /**
     * 消息类型
     */
    private String msgType;

    protected String getToUserName() {
        return toUserName;
    }

    protected void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    protected String getFromUserName() {
        return fromUserName;
    }

    protected void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    protected long getCreateTime() {
        return createTime;
    }

    protected void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    protected String getMsgType() {
        return msgType;
    }

    protected void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
