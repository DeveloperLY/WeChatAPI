package net.developerly.support.wechat.entity.input;

import javax.xml.bind.annotation.XmlElement;

/**
 * 基础消息
 *
 * @author LY
 * @create 2017/06/01
 **/
public class AInputMessageBase extends AInputMessage {
    /**
     * 消息id，64位整型
     */
    private long MsgId;

    @XmlElement(name="MsgId")
    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        this.MsgId = msgId;
    }
}
