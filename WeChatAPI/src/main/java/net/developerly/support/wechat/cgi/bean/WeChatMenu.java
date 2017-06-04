package net.developerly.support.wechat.cgi.bean;

import net.developerly.support.wechat.cgi.HandleMenu;
import net.developerly.support.wechat.cgi.HandleToken;
import net.developerly.support.wechat.exception.WeChatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 微信菜单
 *
 * @author LY
 * @create 2017/06/03
 **/
public class WeChatMenu {
    /**
     * 微信一级菜单最大数量：3
     */
    private List<WeChatButton> button = new ArrayList<WeChatButton>(3);

    private WeChatMenu() {

    }

    /**
     * 获得微信菜单
     * @param buttons
     * @return
     */
    public static WeChatMenu valueOf(WeChatButton...buttons) {
        WeChatMenu menu = new WeChatMenu();
        List<WeChatButton> bs = Arrays.asList(buttons);
        bs = bs.subList(bs.size() - 3 > 0 ? bs.size() - 3 : 0, bs.size());
        menu.button.clear();
        menu.button.addAll(bs);
        return menu;
    }

    /**
     * 创建微信菜单
     * @param token
     * 			微信公众号信息
     * @param buttons
     * 			按钮列表
     * @throws WeChatException
     */
    public static void create(HandleToken token, WeChatButton...buttons) throws WeChatException {
        WeChatMenu menu = WeChatMenu.valueOf(buttons);
        menu.create(token);
    }

    /**
     * 创建微信菜单
     * @param token
     * 			微信公众号信息
     * @throws WeChatException
     */
    public void create(HandleToken token) throws WeChatException {
        if (!button.isEmpty()) {
            HandleMenu.create(token, this);
        }
    }
}
