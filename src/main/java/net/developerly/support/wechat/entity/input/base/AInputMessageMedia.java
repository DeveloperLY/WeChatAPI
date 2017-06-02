package net.developerly.support.wechat.entity.input.base;

import net.developerly.support.wechat.entity.input.AInputMessageBase;

import javax.xml.bind.annotation.XmlElement;

/**
 * 媒体消息
 *
 * @author LY
 * @create 2017/06/01
 **/
public class AInputMessageMedia extends AInputMessageBase {
    /**
     *消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String mediaId;

    @XmlElement(name="MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
