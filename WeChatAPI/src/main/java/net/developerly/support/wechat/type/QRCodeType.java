package net.developerly.support.wechat.type;

/**
 * 二维码类型
 *
 * @author LY
 * @create 2017/06/03
 **/
public enum QRCodeType {
    //QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
    QR_SCENE("QR_SCENE"),
    QR_LIMIT_SCENE("QR_LIMIT_SCENE"),
    QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE");

    private String key;

    private QRCodeType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public boolean equals(String key) {
        return key != null & !key.trim().equals("") & this.key.equalsIgnoreCase(key);
    }
}
