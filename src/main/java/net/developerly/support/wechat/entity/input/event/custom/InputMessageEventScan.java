package net.developerly.support.wechat.entity.input.event.custom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 扫描带参数二维码事件
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputMessageEventScan extends AInputMessageEventCustom {
    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    @XmlElement(name="Ticket")

    private String ticket;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
