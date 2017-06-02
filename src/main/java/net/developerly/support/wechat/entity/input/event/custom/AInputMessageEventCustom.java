package net.developerly.support.wechat.entity.input.event.custom;

import net.developerly.support.wechat.entity.input.AInputMessageEvent;

import javax.xml.bind.annotation.XmlElement;

/**
 * 自定义事件
 *
 * @author LY
 * @create 2017/06/02
 **/
public class AInputMessageEventCustom extends AInputMessageEvent {
    /**
     * 事件KEY值
     */
    private String eventKey;

    @XmlElement(name="EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

}
