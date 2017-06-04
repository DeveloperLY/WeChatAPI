package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.input.AInputMessageEvent;
import net.developerly.support.wechat.entity.input.base.*;

import org.w3c.dom.Document;

/**
 * @author LY
 * @create 2017/06/04
 **/
public interface IInputMessageParser {
    public InputMessageText parserText(Document document);
    public InputMessageImage parserImage(Document document);
    public InputMessageVoice parserVoice(Document document);
    public InputMessageLink parserLink(Document document);
    public InputMessageLocation parserLocation(Document document);
    public InputMessageVideo parserVideo(Document document);
    public AInputMessageEvent parserEvent(Document document);
}
