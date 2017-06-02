package net.developerly.support.wechat.entity.output;

import net.developerly.support.wechat.type.MessageType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

/**
 * 回复文本消息
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputMessageText extends AOutputMessage {

    @XmlElement(name="Content")
    private String content;

    private OutputMessageText() {

    }

    /**
     * 获得文本消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @return
     */
    public static OutputMessageText valueOf(String toUserName, String fromUserName) {
        OutputMessageText text = new OutputMessageText();
        text.setCreateTime(new Date().getTime());
        text.setFromUserName(fromUserName);
        text.setMsgType(MessageType.TEXT.getKey());
        text.setToUserName(toUserName);
        return text;
    }

    /**
     * 获得文本消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @param content
     * 			文本内容
     * @return
     */
    public static OutputMessageText valueOf(String toUserName, String fromUserName, String content) {
        OutputMessageText text = OutputMessageText.valueOf(toUserName, fromUserName);
        text.setContent(content);
        return text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
