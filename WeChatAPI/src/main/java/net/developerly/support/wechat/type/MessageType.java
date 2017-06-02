package net.developerly.support.wechat.type;

/**
 * 信息类型
 *
 * @author LY
 * @create 2017/06/02
 **/
public enum MessageType {

    TEXT("text"),
    LINK("link"),
    EVENT("event"),
    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    LOCATION("location"),
    //以下仅为发送消息类型
    MUSIC("music"),
    NEWS("news"),
    CUSTOMERSERVICE("transfer_customer_service");

    private String key;

    private MessageType(String key){
        this.key=key;
    }

    public String getKey(){
        return key;
    }

    public boolean equals(String key){
        return key!=null & !key.trim().equals("") & this.key.equalsIgnoreCase(key);
    }
}
