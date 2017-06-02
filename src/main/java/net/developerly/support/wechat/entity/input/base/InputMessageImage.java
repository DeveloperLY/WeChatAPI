package net.developerly.support.wechat.entity.input.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 图片消息
 *
 * @author LY
 * @create 2017/06/01
 **/
@XmlRootElement(name="xml")
public class InputMessageImage extends AInputMessageMedia{
    /**
     * 图片链接
     */
    private String picUrl;

    @XmlElement(name="PicUrl")
    public String getPicUrl() {
        return picUrl;
    }
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

}
