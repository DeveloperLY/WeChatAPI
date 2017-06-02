package net.developerly.support.wechat.entity.input.event.custom;

import javax.xml.bind.annotation.*;

/**
 * 发送扫码事件
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputMessageEventSendScanCode extends AInputMessageEventCustom {
    /**
     * 扫描信息
     */
    @XmlElementRef(name="ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo;

    public ScanCodeInfo getScanCodeInfo() {
        return scanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }

    @XmlRootElement(name="ScanCodeInfo")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class ScanCodeInfo {
        /**
         * 扫描类型
         */
        @XmlElement(name="ScanType")
        private String scanType;

        /**
         * 扫描结果
         */
        @XmlElement(name="ScanResult")
        private String scanResult;

        public String getScanType() {
            return scanType;
        }

        public void setScanType(String scanType) {
            this.scanType = scanType;
        }

        public String getScanResult() {
            return scanResult;
        }

        public void setScanResult(String scanResult) {
            this.scanResult = scanResult;
        }

    }

}
