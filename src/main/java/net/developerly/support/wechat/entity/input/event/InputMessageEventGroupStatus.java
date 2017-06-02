package net.developerly.support.wechat.entity.input.event;

import net.developerly.support.wechat.entity.input.AInputMessageEvent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 群发状态事件
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputMessageEventGroupStatus extends AInputMessageEvent {
    /**
     * 消息id
     */
    private String msgId;

    private String status;

    private String totalCount;

    private String filterCount;

    private String sentCount;

    private String errorCount;

    @XmlElement(name="MsgId")
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @XmlElement(name="Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name="TotalCount")
    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    @XmlElement(name="FilterCount")
    public String getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(String filterCount) {
        this.filterCount = filterCount;
    }

    @XmlElement(name="SentCount")
    public String getSentCount() {
        return sentCount;
    }

    public void setSentCount(String sentCount) {
        this.sentCount = sentCount;
    }

    @XmlElement(name="ErrorCount")
    public String getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(String errorCount) {
        this.errorCount = errorCount;
    }

}
