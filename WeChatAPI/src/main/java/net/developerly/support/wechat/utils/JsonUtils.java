package net.developerly.support.wechat.utils;

import net.developerly.support.wechat.exception.WeChatJsonParserException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Json处理工具类
 *
 * @author LY
 * @create 2017/06/03
 **/
public class JsonUtils {

    private static final ObjectMapper objectMapper;
    private static final JsonFactory factory;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        factory = objectMapper.getJsonFactory();
    }

    public static String toJsonStr(final Object object) {
        String rtnStr = "";
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            factory.createJsonGenerator(out).writeObject(object);
            rtnStr = out.toString(CharsetUtils.UTF8.name());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return rtnStr;
    }

    public static<T extends Object> T toBean(final Class<T> clazz,final byte[] datas) throws WeChatJsonParserException {
        T t = null;
        try {
            t = objectMapper.readValue(datas, clazz);
        } catch (Exception exception) {
            throw new WeChatJsonParserException();
        }
        return t;
    }
}
