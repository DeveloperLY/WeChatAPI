package net.developerly.support.wechat.entity.input;

import net.developerly.support.wechat.entity.AMessage;

import javax.xml.bind.annotation.XmlElement;

/**
 * 接收消息基础类
 *
 * @author LY
 * @create 2017/06/01
 **/
public class AInputMessage extends AMessage {
    @Override
    @XmlElement(name="CreateTime")
    public long getCreateTime() {
        return super.getCreateTime();
    }

    @Override
    public void setCreateTime(long CreateTime) {
        super.setCreateTime(CreateTime);
    }

    @Override
    @XmlElement(name="FromUserName")
    public String getFromUserName() {
        return super.getFromUserName();
    }

    @Override
    public void setFromUserName(String fromUserName) {
        super.setFromUserName(fromUserName);
    }

    @Override
    @XmlElement(name="MsgType")
    public String getMsgType() {
        return super.getMsgType();
    }

    @Override
    public void setMsgType(String msgType) {
        super.setMsgType(msgType);
    }

    @Override
    @XmlElement(name="ToUserName")
    public String getToUserName() {
        return super.getToUserName();
    }

    @Override
    public void setToUserName(String toUserName) {
        super.setToUserName(toUserName);
    }
}
