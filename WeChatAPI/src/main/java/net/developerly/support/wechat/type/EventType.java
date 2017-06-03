package net.developerly.support.wechat.type;

/**
 * 事件类型
 *
 * @author LY
 * @create 2017/06/03
 **/
// TODO 需增加方法获得Key方法
// TODO 发送时JSON数据全为小写
public enum EventType {
    //系统事件
    SUBSCRIBE("subscribe"),
    UNSUBSCRIBE("unsubscribe"),
    SCAN("SCAN"),
    LOCATION("LOCATION"),
    //自定义事件
    VIEW("VIEW"),
    CLICK("CLICK"),
    SCANCODEPUSH("scancode_push"),
    SCANCODEWAITMSG("scancode_waitmsg"),
    PICSYSPHOTO("pic_sysphoto"),
    PICPHOTOORALBUM("pic_photo_or_album"),
    PICWEIXIN("pic_weixin"),
    LOCATIONSELECT("location_select"),
    //状态事件
    MASEND("MASSENDJOBFINISH"),
    TEMPLATE("TEMPLATESENDJOBFINISH");


    private String key;

    private EventType(String key) {
        this.key = key;
    }

    public boolean equals(String key) {
        return key != null & !key.trim().equals("") & this.key.equalsIgnoreCase(key);
    }
}
