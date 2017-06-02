package net.developerly.support.wechat.entity.output;

import net.developerly.support.wechat.type.MessageType;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * 回复音乐消息
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputMessageMusic extends AOutputMessage {

    @XmlElementRef(name="Music")
    private Music music = new Music();

    private OutputMessageMusic() {

    };

    /**
     * 获得音乐消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @return
     */
    public static OutputMessageMusic valueOf(String toUserName, String fromUserName) {
        OutputMessageMusic outputMusic = new OutputMessageMusic();
        outputMusic.setCreateTime(new Date().getTime());
        outputMusic.setFromUserName(fromUserName);
        outputMusic.setMsgType(MessageType.MUSIC.getKey());
        outputMusic.setToUserName(toUserName);
        return outputMusic;
    }

    /**
     * 获得音乐消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @param title
     * 			标题
     * @param description
     * 			描述
     * @param musicURL
     * 			音乐地址
     * @param hqMusicURL
     * 			音乐高清地址
     * @param thumbMediaId
     * 			媒休ID
     * @return
     */
    public static OutputMessageMusic valueOf(String toUserName, String fromUserName, String title, String description, String musicURL, String hqMusicURL, String thumbMediaId) {
        OutputMessageMusic outputMusic = OutputMessageMusic.valueOf(toUserName, fromUserName);
        outputMusic.setTitle(title);
        outputMusic.setDescription(description);
        outputMusic.setHqMusicUrl(hqMusicURL);
        outputMusic.setMusicURL(musicURL);
        outputMusic.setThumbMediaId(thumbMediaId);
        return outputMusic;
    }

    public String getTitle() {
        return music.getTitle();
    }

    public void setTitle(String title) {
        music.setTitle(title);
    }

    public String getDescription() {
        return music.getDescription();
    }

    public void setDescription(String description) {
        music.setDescription(description);
    }

    public String getMusicURL() {
        return music.getMusicURL();
    }

    public void setMusicURL(String musicURL) {
        music.setMusicURL(musicURL);
    }

    public String getHqMusicUrl() {
        return music.getHqMusicUrl();
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        music.setHqMusicUrl(hqMusicUrl);
    }

    public String getThumbMediaId() {
        return music.getThumbMediaId();
    }

    public void setThumbMediaId(String thumbMediaId) {
        music.setThumbMediaId(thumbMediaId);
    }

    @XmlRootElement(name="Music")
    static class Music {

        private String title;
        private String description;
        private String musicURL;
        private String hqMusicUrl;
        private String thumbMediaId;

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

        @XmlElement(name="MusicUrl")
        public String getMusicURL() {
            return musicURL;
        }

        public void setMusicURL(String musicURL) {
            this.musicURL = musicURL;
        }

        @XmlElement(name="HQMusicUrl")
        public String getHqMusicUrl() {
            return hqMusicUrl;
        }

        public void setHqMusicUrl(String hqMusicUrl) {
            this.hqMusicUrl = hqMusicUrl;
        }

        @XmlElement(name="ThumbMediaId")
        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }
}
