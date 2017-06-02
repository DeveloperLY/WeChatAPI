package net.developerly.support.wechat.entity.output;

import net.developerly.support.wechat.type.MessageType;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * 回复语音消息
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputMessageVoice extends AOutputMessage  {

    @XmlElementRef(name="Voice")
    private Voice voice = new Voice();

    private OutputMessageVoice() {

    }

    /**
     * 获得音频消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @return
     */
    public static OutputMessageVoice valueOf(String toUserName, String fromUserName){
        OutputMessageVoice voice = new OutputMessageVoice();
        voice.setCreateTime(new Date().getTime());
        voice.setFromUserName(fromUserName);
        voice.setMsgType(MessageType.VOICE.getKey());
        voice.setToUserName(toUserName);
        return voice;
    }

    /**
     * 获得音频消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @param mediaId
     * 			媒体ID
     * @return
     */
    public static OutputMessageVoice valueOf(String toUserName, String fromUserName, String mediaId){
        OutputMessageVoice voice = OutputMessageVoice.valueOf(toUserName, fromUserName);
        voice.setMediaId(mediaId);
        return voice;
    }

    public String getMediaId() {
        return voice.getMediaId();
    }

    public void setMediaId(String mediaId) {
        voice.setMediaId(mediaId);
    }

    @XmlRootElement(name="Voice")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Voice {

        @XmlElement(name="MediaId")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

    }

}
