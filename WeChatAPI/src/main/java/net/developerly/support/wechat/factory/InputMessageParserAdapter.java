package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.input.AInputMessageEvent;
import net.developerly.support.wechat.entity.input.base.*;
import net.developerly.support.wechat.entity.input.event.InputMessageEvent;
import net.developerly.support.wechat.entity.input.event.InputMessageEventGroupStatus;
import net.developerly.support.wechat.entity.input.event.InputMessageEventLocation;
import net.developerly.support.wechat.entity.input.event.InputMessageEventTemplateStatus;
import net.developerly.support.wechat.entity.input.event.custom.*;
import net.developerly.support.wechat.type.EventType;
import net.developerly.support.wechat.utils.ElementUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * 此适配器使用  JAXBContext 进行转换，
 * 使用注解进行映射配置，所以只兼容1.5以上JDK
 *
 * @author LY
 * @create 2017/06/04
 **/
public class InputMessageParserAdapter implements IInputMessageParser {

    @Override
    public InputMessageText parserText(Document document) {
        InputMessageText text = unmarshaller(InputMessageText.class, document);
        return text != null ? text : new InputMessageText();
    }

    @Override
    public InputMessageImage parserImage(Document document) {
        InputMessageImage image = unmarshaller(InputMessageImage.class, document);
        return image != null ? image : new InputMessageImage();
    }

    @Override
    public InputMessageVoice parserVoice(Document document) {
        InputMessageVoice voice = unmarshaller(InputMessageVoice.class, document);
        return voice != null ? voice : new InputMessageVoice();
    }

    @Override
    public InputMessageLink parserLink(Document document) {
        InputMessageLink link = unmarshaller(InputMessageLink.class, document);
        return link != null ? link : new InputMessageLink();
    }

    @Override
    public InputMessageLocation parserLocation(Document document) {
        InputMessageLocation location = unmarshaller(InputMessageLocation.class, document);
        return location != null ? location : new InputMessageLocation();
    }

    @Override
    public InputMessageVideo parserVideo(Document document) {
        InputMessageVideo video = unmarshaller(InputMessageVideo.class, document);
        return video != null ? video : new InputMessageVideo();
    }

    @Override
    public AInputMessageEvent parserEvent(Document document) {
        Node node = document.getElementsByTagName(ElementUtils.XML_ELEMENT_EVENT).item(0);
        Node node2 = document.getElementsByTagName(ElementUtils.XML_ELEMENT_TICKET).item(0);
        String messageType = node.getTextContent();
        if (EventType.CLICK.equals(messageType)) {
            return parserClick(document);
        } else if (EventType.VIEW.equals(messageType)) {
            return parserView(document);
        } else if (EventType.SCANCODEPUSH.equals(messageType) || EventType.SCANCODEWAITMSG.equals(messageType)) {
            return parserScanCode(document);
        } else if (EventType.PICPHOTOORALBUM.equals(messageType) || EventType.PICSYSPHOTO.equals(messageType) || EventType.PICWEIXIN.equals(messageType)) {
            return parserPicture(document);
        } else if (EventType.LOCATIONSELECT.equals(messageType)) {
            return parserLocationSelect(document);
        } else if (EventType.TEMPLATE.equals(messageType)) {
            return parserTemplageStatus(document);
        } else if (EventType.MASEND.equals(messageType)) {
            return parserMassedJobFinish(document);
        } else if (EventType.UNSUBSCRIBE.equals(messageType) || EventType.SUBSCRIBE.equals(messageType) && node2 == null) {
            return parserSubscribe(document);
        } else if (EventType.SCAN.equals(messageType) || EventType.SUBSCRIBE.equals(messageType)){
            return parserScan(document);
        } else if (EventType.LOCATION.equals(messageType)) {
            return parserUploadLocation(document);
        }

        return null;
    }

    // 此部分为系统Event事件
    private InputMessageEvent parserSubscribe(Document document) {
        return unmarshaller(InputMessageEvent.class, document);
    }

    private InputMessageEventScan parserScan(Document document) {
        return unmarshaller(InputMessageEventScan.class, document);
    }

    private InputMessageEventLocation parserUploadLocation(Document document) {
        return unmarshaller(InputMessageEventLocation.class, document);
    }

    // 此部分为状态Event事件
    private InputMessageEventTemplateStatus parserTemplageStatus(Document document) {
        return unmarshaller(InputMessageEventTemplateStatus.class, document);
    }

    private InputMessageEventGroupStatus parserMassedJobFinish(Document document){
        return unmarshaller(InputMessageEventGroupStatus.class, document);
    }

    // 此部分为自定义Event事件
    private InputMessageEventCustom parserClick(Document document) {
        return unmarshaller(InputMessageEventCustom.class, document);
    }

    private InputMessageEventCustom parserView(Document document) {
        return unmarshaller(InputMessageEventCustom.class, document);
    }

    private InputMessageEventSendScanCode parserScanCode(Document document) {
        return unmarshaller(InputMessageEventSendScanCode.class, document);
    }

    private InputMessageEventSendPicture parserPicture(Document document) {
        return unmarshaller(InputMessageEventSendPicture.class, document);
    }

    private InputMessageEventSendLocation parserLocationSelect(Document document) {
        return unmarshaller(InputMessageEventSendLocation.class, document);
    }


    private <T> T unmarshaller(Class<T> clazz, Document document) {
        try {
             JAXBContext context=JAXBContext.newInstance(clazz);
             Unmarshaller unmarshaller = context.createUnmarshaller();
             T message = (T)unmarshaller.unmarshal(document);
             return message;
        } catch (JAXBException e) {
             // TODO JAXB 序列化出错，是否需要处理
             e.printStackTrace();
        }
        return null;
    }
}
