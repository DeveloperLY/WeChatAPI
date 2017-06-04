package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.output.*;

/**
 * @author LY
 * @create 2017/06/04
 **/
public class OutputMessageFactory {

    private static final OutputMessageFactory FACTORY = new OutputMessageFactory();
    private static final IOutputMessageParser XML_PARSER = new OutputMessageParserToXMLAdapter();
    private static final IOutputMessageParser JSON_PARSER = new OutputMessageParserToJSONAdapter();

    private OutputMessageFactory() {

    }

    public static OutputMessageFactory getInstance() {
        return FACTORY;
    }
    /**
     * 生成XML字符串
     * @param msg
     * 			回复消息
     * @return
     */
    public String toXML(AOutputMessage msg) {
        if (msg instanceof OutputMessageVideo) {
            return toXML((OutputMessageVideo)msg);
        } else if (msg instanceof OutputMessageVoice) {
            return toXML((OutputMessageVoice)msg);
        } else if (msg instanceof OutputMessageNews) {
            return toXML((OutputMessageNews)msg);
        } else if (msg instanceof OutputMessageMusic) {
            return toXML((OutputMessageMusic)msg);
        } else if (msg instanceof OutputMessageImage) {
            return toXML((OutputMessageImage)msg);
        } else if (msg instanceof OutputMessageText) {
            return toXML((OutputMessageText)msg);
        } else {
            return "";
        }
    }
    /**
     * 生成JSON 字符串
     * @param msg
     * 			回复消息
     * @return
     */
    public String toJSON(AOutputMessage msg) {
        if (msg instanceof OutputMessageVideo) {
            return toJSON((OutputMessageVideo)msg);
        } else if (msg instanceof OutputMessageVoice) {
            return toJSON((OutputMessageVoice)msg);
        } else if (msg instanceof OutputMessageNews) {
            return toJSON((OutputMessageNews)msg);
        } else if (msg instanceof OutputMessageMusic) {
            return toJSON((OutputMessageMusic)msg);
        } else if (msg instanceof OutputMessageImage) {
            return toJSON((OutputMessageImage)msg);
        } else if (msg instanceof OutputMessageText) {
            return toJSON((OutputMessageText)msg);
        } else {
            return "";
        }
    }

    private String toXML(OutputMessageImage image) {
        return XML_PARSER.parser(image);
    }

    private String toXML(OutputMessageMusic music){
        return XML_PARSER.parser(music);
    }

    private String toXML(OutputMessageNews news) {
        return XML_PARSER.parser(news);
    }

    private String toXML(OutputMessageText text){
        return XML_PARSER.parser(text);
    }

    private String toXML(OutputMessageVideo video) {
        return XML_PARSER.parser(video);
    }

    private String toXML(OutputMessageVoice voice){
        return XML_PARSER.parser(voice);
    }

    private String toJSON(OutputMessageImage image) {
        return JSON_PARSER.parser(image);
    }

    private String toJSON(OutputMessageMusic music) {
        return JSON_PARSER.parser(music);
    }

    private String toJSON(OutputMessageNews news){
        return JSON_PARSER.parser(news);
    }

    private String toJSON(OutputMessageText text) {
        return JSON_PARSER.parser(text);
    }

    private String toJSON(OutputMessageVideo video) {
        return JSON_PARSER.parser(video);
    }

    private String toJSON(OutputMessageVoice voice){
        return JSON_PARSER.parser(voice);
    }
}
