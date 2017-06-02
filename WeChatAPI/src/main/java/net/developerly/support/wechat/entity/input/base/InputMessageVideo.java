package net.developerly.support.wechat.entity.input.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 视频消息
 *
 * @author LY
 * @create 2017/06/01
 **/
@XmlRootElement(name="xml")
public class InputMessageVideo extends AInputMessageMedia {
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String thumbMediaId;

    @XmlElement(name="ThumbMediaId")
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
