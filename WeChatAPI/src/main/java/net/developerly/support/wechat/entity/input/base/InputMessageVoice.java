package net.developerly.support.wechat.entity.input.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 语音消息
 *
 * @author LY
 * @create 2017/06/01
 **/
@XmlRootElement(name="xml")
public class InputMessageVoice extends AInputMessageMedia  {
    /**
     * 语音格式，如amr，speex等
     */
    private String format;

    @XmlElement(name="Format")
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
