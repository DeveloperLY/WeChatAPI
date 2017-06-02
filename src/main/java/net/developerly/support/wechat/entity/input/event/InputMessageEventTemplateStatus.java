package net.developerly.support.wechat.entity.input.event;

import net.developerly.support.wechat.entity.input.AInputMessageEvent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 模版消息状态事件
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputMessageEventTemplateStatus extends AInputMessageEvent {

    /**
     * 模版信息状态
     */
    private String status;

    /**
     * 消息id
     */
    private String msgId;

    @XmlElement(name="Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name="MsgId")
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

}
