package net.developerly.support.wechat.entity.input.base;

import net.developerly.support.wechat.entity.input.AInputMessageBase;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 文本消息
 *
 * @author LY
 * @create 2017/06/01
 **/
@XmlRootElement(name="xml")
public class InputMessageText extends AInputMessageBase {
    /**
     * 文本消息内容
     */
    private String content;

    @XmlElement(name="Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
