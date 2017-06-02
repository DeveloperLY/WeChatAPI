package net.developerly.support.wechat.entity.input.event.custom;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 发送图片事件
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputMessageEventSendPicture extends AInputMessageEventCustom {
    /**
     * 发送图片信息
     */
    @XmlElementRef(name="SendPicsInfo")
    private SendPicsInfo sendPicsInfo;

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }

    @XmlRootElement(name="SendPicsInfo")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class SendPicsInfo {

        /**
         * 发送的图片数量
         */
        @XmlElement(name="Count")
        private String count;

        /**
         * 图片列表
         */
        @XmlElement(name="PicList")
        private List<Item> picList;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<Item> getPicList() {
            return picList;
        }

        public void setPicList(List<Item> picList) {
            this.picList = picList;
        }

    }

    static class Item {
        /**
         * 图片的MD5值
         */
        private String PicMd5Sum;

        public String getPicMd5Sum() {
            return PicMd5Sum;
        }

        public void setPicMd5Sum(String picMd5Sum) {
            PicMd5Sum = picMd5Sum;
        }

    }
}
