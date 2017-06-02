package net.developerly.support.wechat.entity.output;

import net.developerly.support.wechat.type.MessageType;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * 回复视频消息
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputMessageVideo extends AOutputMessage {

    @XmlElementRef(name="Video")
    private Video video = new Video();

    private OutputMessageVideo() {

    }

    /**
     * 获得视频消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @return
     */
    public static OutputMessageVideo valueOf(String toUserName, String fromUserName) {
        OutputMessageVideo video = new OutputMessageVideo();
        video.setCreateTime(new Date().getTime());
        video.setFromUserName(fromUserName);
        video.setMsgType(MessageType.VIDEO.getKey());
        video.setToUserName(toUserName);
        return video;
    }

    /**
     * 获得视频消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @param mediaId
     * 			媒体ID
     * @param title
     * 			消息标题
     * @param description
     * 			消息描述
     * @return
     */
    public static OutputMessageVideo valueOf(String toUserName, String fromUserName, String mediaId, String title, String description) {
        OutputMessageVideo video=OutputMessageVideo.valueOf(toUserName, fromUserName);
        video.setMediaId(mediaId);
        video.setTitle(title);
        video.setDescription(description);
        return video;
    }

    @XmlTransient
    public String getMediaId() {
        return video.getMediaId();
    }

    public void setMediaId(String mediaId) {
        video.setMediaId(mediaId);
    }

    @XmlTransient
    public String getTitle() {
        return video.getTitle();
    }

    public void setTitle(String title) {
        video.setTitle(title);
    }

    @XmlTransient
    public String getDescription() {
        return video.getDescription();
    }

    public void setDescription(String description) {
        video.setDescription(description);
    }

    @XmlRootElement(name="Video")
    static class Video {

        private String mediaId;
        private String title;
        private String description;

        @XmlElement(name="MediaId")
        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

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

    }

}
