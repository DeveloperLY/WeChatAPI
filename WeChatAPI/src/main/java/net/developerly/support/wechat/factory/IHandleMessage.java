package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.input.AInputMessageEvent;
import net.developerly.support.wechat.entity.input.InputMessageUnknow;
import net.developerly.support.wechat.entity.input.base.*;
import net.developerly.support.wechat.entity.output.AOutputMessage;

import java.util.List;

/**
 * @author LY
 * @create 2017/06/04
 **/
public interface IHandleMessage {
    /**
     * 收到文本消息
     * @param text
     * @param outputs
     */
    public void onText(InputMessageText text , final List<AOutputMessage> outputs);

    /**
     * 收到图片消息
     * @param image
     * @param outputs
     */
    public void onImage(InputMessageImage image, final List<AOutputMessage> outputs);

    /**
     * 收到事件推送消息
     * location_select 事件：
     * 		接收：InputMessageEventSendLocation
     * 		回复：CGI回复
     * pic_sysphoto 事件：
     * 		接收：空
     * 		回复：待定
     * 		作用：校验后续的图片信息
     * pic_photo_or_album 事件：
     * 		接收：InputMessageEventSendPicture
     * 		回复：CGI回复
     * 		作用：校验后续的图片信息
     * pic_weixin 事件：
     * 		接收：InputMessageEventSendPicture
     * 		回复：CGI回复
     * 		作用：校验后续的图片信息
     * scancode_push 事件：
     * 		接收：InputMessageEventSendScanCode
     * 		回复：CGI回复
     * scancode_waitmsg 事件：
     * 		接收：InputMessageEventSendScanCode
     * 		回复：CGI回复、直接回复
     * @param event 推送事件
     * @param outputs 需要回复的内容
     */
    public void onEvent(AInputMessageEvent event, final List<AOutputMessage> outputs);

    /**
     * 收到链接消息
     * @param link
     * @param outputs
     */
    public void onLink(InputMessageLink link, final List<AOutputMessage> outputs);

    /**
     * 收到地理位置消息
     * @param location
     * @param outputs
     */
    public void onLocation(InputMessageLocation location, final List<AOutputMessage> outputs);

    /**
     * 语音识别消息
     * @param voice
     * @param outputs
     */
    public void onVoice(InputMessageVoice voice,final List<AOutputMessage> outputs);

    /**
     * 视频消息
     * @param video
     * @param outputs
     */
    public void onVideo(InputMessageVideo video, final List<AOutputMessage> outputs);


    /**
     * 处理未定义信息,为占位方法，暂时可以不进行实现
     * @param other
     * @param outputs
     */
    public void onOther(InputMessageUnknow other, List<AOutputMessage> outputs);

}
