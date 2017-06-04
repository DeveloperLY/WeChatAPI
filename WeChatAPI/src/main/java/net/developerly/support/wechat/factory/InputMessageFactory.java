package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.input.AInputMessage;
import net.developerly.support.wechat.entity.input.AInputMessageEvent;
import net.developerly.support.wechat.entity.input.InputMessageUnknow;
import net.developerly.support.wechat.entity.input.base.*;
import net.developerly.support.wechat.utils.CharsetUtils;
import net.developerly.support.wechat.utils.ElementUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author LY
 * @create 2017/06/04
 **/
public class  InputMessageFactory {

    private static final String PARSER_METHOD_PREFIX = "parser";

    private static final InputMessageFactory FACTORY = new InputMessageFactory();

    private IInputMessageParser parser = new InputMessageParserAdapter();

    private InputMessageFactory() {

    }

    protected static InputMessageFactory newInstance() {
        return new InputMessageFactory();
    }

    public static InputMessageFactory getInstance() {
        return FACTORY;
    }

    /**
     * 将传入数据流反序化成AInputMessage对像
     * @param in
     * 			Xml数据流，编码必须为UTF-8
     * @return
     * 			AInputMessage 子类：
     * 				InputMessageText,InputMessageImage,InputMessageLocation,
     * 				InputMessageVoice,InputMessageVideo,InputMessageLink,
     * 				InputMessageUnknow,AInputMessageEvent
     *
     * TODO 传入参数需进行格式校验
     */
    public AInputMessage toInputMessage(InputStream in) {
        AInputMessage message = new InputMessageUnknow();
        try {
             Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
             Node node = document.getElementsByTagName(ElementUtils.XML_ELEMENT_MSGTYPE).item(0);
             String messageType = node.getTextContent();
             StringBuffer methodName = new StringBuffer();
             methodName.append(PARSER_METHOD_PREFIX);
             methodName.append(messageType.substring(0,1).toUpperCase());
             methodName.append(messageType.substring(1).toLowerCase());
             Method method = this.getClass().getDeclaredMethod(methodName.toString(), Document.class);
             method.setAccessible(false);
             message = (AInputMessage)method.invoke(this, document);
        } catch (Exception e) {
             //TODO 此处错误需写入数据日志
             e.printStackTrace();
        }
        return message;
    }

    public <T> String toXml(T t) {
        String rtnStr="jaxb marshaller error.";
        try {
             ByteArrayOutputStream os = new ByteArrayOutputStream();
             JAXBContext context = JAXBContext.newInstance(t.getClass());
             Marshaller marshaller = context.createMarshaller();
             marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
             marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
             marshaller.setProperty(Marshaller.JAXB_ENCODING, CharsetUtils.UTF8.name());
             marshaller.marshal(t,os);
             byte[] data = os.toByteArray();
             return new String(data,CharsetUtils.UTF8);
        } catch(Exception e) {
            //TODO 错误信息
            e.printStackTrace();
        }
        return rtnStr;
    }

    protected InputMessageText parserText(Document cocument) {
        return parser.parserText(cocument);
    }

    protected InputMessageImage parserImage(Document document) {
        return parser.parserImage(document);
    }

    protected InputMessageVoice parserVoice(Document document) {
        return parser.parserVoice(document);
    }

    protected InputMessageLink parserLink(Document document) {
        return parser.parserLink(document);
    }

    protected InputMessageLocation parserLocation(Document document) {
        return parser.parserLocation(document);
    }

    protected InputMessageVideo parserVideo(Document document) {
        return parser.parserVideo(document);
    }

    protected AInputMessageEvent parserEvent(Document document) {
        return parser.parserEvent(document);
    }

}
