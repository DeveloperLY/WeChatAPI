package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.output.*;
import net.developerly.support.wechat.utils.CharsetUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

/**
 * 此适配器使用  JAXBContext 进行转换，
 * 使用注解进行映射配置，所以只兼容1.5以上JDK
 *
 * @author LY
 * @create 2017/06/04
 **/
public class OutputMessageParserToXMLAdapter implements IOutputMessageParser {

    @Override
    public String parser(OutputMessageVideo video) {
        return marshaller(video);
    }

    @Override
    public String parser(OutputMessageVoice voice) {
        return marshaller(voice);
    }

    @Override
    public String parser(OutputMessageImage image) {
        return marshaller(image);
    }

    @Override
    public String parser(OutputMessageMusic music) {
        return marshaller(music);
    }

    @Override
    public String parser(OutputMessageNews news) {
        return marshaller(news);
    }

    @Override
    public String parser(OutputMessageText text) {
        return marshaller(text);
    }

    private String  marshaller(AOutputMessage msg) {
        try {

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            JAXBContext context = JAXBContext.newInstance(msg.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, CharsetUtils.UTF8.name());
            marshaller.marshal(msg,os);
            byte[] data = os.toByteArray();
            return new String(data,CharsetUtils.UTF8);

        } catch (JAXBException e) {
            // TODO JAXB 序列化出错，是否需要处理
            e.printStackTrace();
        }
        return "";
    }

}
