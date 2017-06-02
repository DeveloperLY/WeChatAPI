package net.developerly.support.wechat.entity.input.event.custom;

import javax.xml.bind.annotation.*;

/**
 * 地理位置事件
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputMessageEventSendLocation extends AInputMessageEventCustom {
    /**
     * 发送的位置信息
     */
    @XmlElementRef(name="SendLocationInfo")
    private SendLocationInfo sendLocationInfo;

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }

    @XmlRootElement(name="SendLocationInfo")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class SendLocationInfo {
        /**
         * X坐标信息
         */
        @XmlElement(name="Location_X")
        private String locationX;

        /**
         * Y坐标信息
         */
        @XmlElement(name="Location_Y")
        private String locationY;

        /**
         * 精度，可理解为精度或者比例尺、越精细的话 scale越高
         */
        @XmlElement(name="Scale")
        private String scale;

        /**
         * 地理位置的字符串信息
         */
        @XmlElement(name="Label")
        private String label;

        /**
         * 朋友圈POI的名字，可能为空
         */
        @XmlElement(name="Poiname")
        private String poiname;

        public String getLocationX() {
            return locationX;
        }

        public void setLocationX(String locationX) {
            this.locationX = locationX;
        }

        public String getLocationY() {
            return locationY;
        }

        public void setLocationY(String locationY) {
            this.locationY = locationY;
        }

        public String getScale() {
            return scale;
        }

        public void setScale(String scale) {
            this.scale = scale;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getPoiname() {
            return poiname;
        }

        public void setPoiname(String poiname) {
            this.poiname = poiname;
        }

    }

}
