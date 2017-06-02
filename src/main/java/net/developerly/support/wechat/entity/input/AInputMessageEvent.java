package net.developerly.support.wechat.entity.input;

import javax.xml.bind.annotation.XmlElement;

/**
 * 事件消息
 *
 * @author LY
 * @create 2017/06/01
 **/
public class AInputMessageEvent extends AInputMessage {
    /**
     * 事件类型
     */
    private String event;
    @XmlElement(name="Event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

}
