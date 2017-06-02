package net.developerly.support.wechat.entity.output;

import net.developerly.support.wechat.type.MessageType;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * 回复图片消息
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputMessageImage extends AOutputMessage {

    @XmlElementRef(name="Image")
    private Image image = new Image();

    private OutputMessageImage() {

    }

    /**
     * 获得图文消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			从公号ID
     * @return
     */
    public static OutputMessageImage valueOf(String toUserName, String fromUserName) {
        OutputMessageImage image = new OutputMessageImage();
        image.setCreateTime(new Date().getTime());
        image.setFromUserName(fromUserName);
        image.setToUserName(toUserName);
        image.setMsgType(MessageType.IMAGE.getKey());
        return image;
    }

    /**
     *  获得图文消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @param mediaId
     * 			媒体ID
     * @return
     */
    public static OutputMessageImage valueOf(String toUserName, String fromUserName, String mediaId) {
        OutputMessageImage image = OutputMessageImage.valueOf(toUserName, fromUserName);
        image.setMediaId(mediaId);
        return image;
    }

    public String getMediaId() {
        return image.getMediaId();
    }

    public void setMediaId(String mediaId) {
        image.setMediaId(mediaId);
    }

    @XmlRootElement(name="Image")
    static class Image {

        private String mediaId;

        @XmlElement(name="MediaId")
        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

    }
}
