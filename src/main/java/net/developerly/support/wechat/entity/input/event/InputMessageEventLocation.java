package net.developerly.support.wechat.entity.input.event;

import net.developerly.support.wechat.entity.input.AInputMessageEvent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 上报地理位置事件
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputMessageEventLocation extends AInputMessageEvent {
    /**
     * 地理位置纬度
     */
    @XmlElement(name="Precision")
    private String latitude;

    /**
     * 地理位置经度
     */
    @XmlElement(name="Latitude")
    private String longitude;

    /**
     * 地理位置精度
     */
    @XmlElement(name="Longitude")
    private String Precision;


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

}
