package net.developerly.support.wechat.entity.output;

import net.developerly.support.wechat.entity.AMessage;

import javax.xml.bind.annotation.XmlElement;

/**
 * 回复抽象类
 *
 * @author LY
 * @create 2017/06/02
 **/
public abstract class AOutputMessage extends AMessage {
    @Override
    @XmlElement(name="CreateTime")
    public long getCreateTime() {
        return super.getCreateTime();
    }

    @Override
    @XmlElement(name="FromUserName")
    public String getFromUserName() {
        return super.getFromUserName();
    }

    @Override
    @XmlElement(name="MsgType")
    public String getMsgType() {
        return super.getMsgType();
    }

    @Override
    @XmlElement(name="ToUserName")
    public String getToUserName() {
        return super.getToUserName();
    }

}
