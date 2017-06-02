package net.developerly.support.wechat.entity.input.base;

import net.developerly.support.wechat.entity.input.AInputMessageBase;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 链接消息
 *
 * @author LY
 * @create 2017/06/01
 **/
@XmlRootElement(name="xml")
public class InputMessageLink extends AInputMessageBase {
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息描述
     */
    private String description;
    /**
     * 消息链接
     */
    private String url;

    @XmlElement(name="Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @XmlElement(name="Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name="Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
