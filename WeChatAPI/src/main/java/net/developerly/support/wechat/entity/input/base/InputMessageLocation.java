package net.developerly.support.wechat.entity.input.base;

import net.developerly.support.wechat.entity.input.AInputMessageBase;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 地理位置消息
 *
 * @author LY
 * @create 2017/06/01
 **/
@XmlRootElement(name="xml")
public class InputMessageLocation extends AInputMessageBase {
    /**
     * 地理位置维度
     */
    private String locationX;
    /**
     * 地理位置经度
     */
    private String locationY;
    /**
     * 地图缩放大小
     */
    private String scale;
    /**
     * 地理位置信息
     */
    private String label;

    @XmlElement(name="Location_X")
    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    @XmlElement(name="Location_Y")
    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    @XmlElement(name="Scale")
    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    @XmlElement(name="Label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
