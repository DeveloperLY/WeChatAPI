package net.developerly.support.wechat.cgi.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 微信按钮
 *
 * @author LY
 * @create 2017/06/03
 **/
public class WeChatButton {

    /** 按键名称 */
    private String name;

    /** 按键类型 */
    private String type;

    /** 按键标识 */
    private String key;

    /** 跳转地址 */
    private String url;

    /**
     * 子级菜单
     * 微信规定二级菜单最大数量：5
     */
    private List<WeChatButton> sub_button = new ArrayList<WeChatButton>();

    private WeChatButton() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 添加子按钮
     * @param buttons
     * 			子按钮列表
     */
    public void addChildren(WeChatButton...buttons) {
        List<WeChatButton> bs = Arrays.asList(buttons);
        bs = bs.subList(bs.size() - 5 > 0 ? bs.size() - 5 : 0, bs.size());
        this.sub_button.clear();
        this.sub_button.addAll(bs);
    }

    /**
     * 获得微信按钮
     * @param name
     * 			名称
     * @param type
     * 			类型
     * @param content
     * 			关键标识/URL
     * 注意：
     * 		当类型为view时，content应为URL地址
     * @return
     */
    public static WeChatButton valueOf(String name, String type, String content) {
        WeChatButton button = new WeChatButton();
        button.setName(name);
        button.setType(type);
        button.setKey(content);
        button.setUrl(content);
        return button;
    }

}
