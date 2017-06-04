package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.cgi.HandleToken;
import net.developerly.support.wechat.cgi.SendService;
import net.developerly.support.wechat.entity.input.AInputMessage;
import net.developerly.support.wechat.entity.input.AInputMessageEvent;
import net.developerly.support.wechat.entity.input.base.*;
import net.developerly.support.wechat.entity.output.AOutputMessage;
import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.utils.CharsetUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理微信消息
 *
 * @author LY
 * @create 2017/06/04
 **/
// TODO 使用引用传参，可能会有问题，是否修改成直接返回
// TODO 此处可能存在并发问题
// TODO 此处需做成异步处理
public class HandleFactory {

    private static final IHandleMessage defaultHandle = new HandleMessageAdapter();

    private List<IHandleMessage> customs = new ArrayList<IHandleMessage>();

    private Object lockCustomes = new Object();

    private HandleFactory() {

    }

    public static final HandleFactory getInstance(){
        return valueOf(defaultHandle);
    }

    public static final HandleFactory valueOf(final IHandleMessage h_msg){
        List<IHandleMessage> list = new ArrayList<IHandleMessage>();
        list.add(h_msg);
        return valueOf(list);
    }

    public static final HandleFactory valueOf(final List<IHandleMessage> h_msg_s) {
        HandleFactory factory = new HandleFactory();
        factory.customs.clear();
        factory.customs.addAll(h_msg_s);
        return factory;
    }

    public void handle(AInputMessage msg, OutputStream out, HandleToken token) throws IOException, WeChatException {
        if (msg instanceof InputMessageText) handle((InputMessageText)msg, out, token);
        else if (msg instanceof InputMessageImage) handle((InputMessageImage)msg, out, token);
        else if (msg instanceof InputMessageLocation) handle((InputMessageLocation)msg, out, token);
        else if (msg instanceof InputMessageLink) handle((InputMessageLink)msg, out, token);
        else if (msg instanceof InputMessageVideo) handle((InputMessageVideo)msg, out, token);
        else if (msg instanceof InputMessageVoice) handle((InputMessageVoice)msg, out, token);
        else if (msg instanceof AInputMessageEvent) handle((AInputMessageEvent)msg, out, token);
        else sendEmpty(out);

    }

    private void handle(InputMessageText text,OutputStream output,HandleToken token) throws IOException, WeChatException {
        List<AOutputMessage> outs = new ArrayList<AOutputMessage>();
        for (IHandleMessage handle : customs) {
            handle.onText(text, outs);
        }
        sendMessage(outs, output, token);
    }

    private void handle(InputMessageImage image, OutputStream output, HandleToken token) throws IOException, WeChatException {
        List<AOutputMessage> outs = new ArrayList<AOutputMessage>();
        for (IHandleMessage handle : customs) {
            handle.onImage(image, outs);
        }
        sendMessage(outs, output, token);
    }

    private void handle(InputMessageLink link, OutputStream output, HandleToken token) throws IOException, WeChatException {
        List<AOutputMessage> outs = new ArrayList<AOutputMessage>();
        for (IHandleMessage handle : customs) {
            handle.onLink(link, outs);
        }
        sendMessage(outs, output, token);
    }

    private void handle(InputMessageLocation location, OutputStream output, HandleToken token) throws IOException, WeChatException {
        List<AOutputMessage> outs = new ArrayList<AOutputMessage>();
        for (IHandleMessage handle : customs) {
            handle.onLocation(location, outs);
        }
        sendMessage(outs, output, token);
    }

    private void handle(InputMessageVideo video, OutputStream output, HandleToken token) throws IOException, WeChatException {
        List<AOutputMessage> outs = new ArrayList<AOutputMessage>();
        for (IHandleMessage handle : customs) {
            handle.onVideo(video, outs);
        }
        sendMessage(outs, output, token);
    }

    private void handle(InputMessageVoice voice, OutputStream output, HandleToken token) throws IOException, WeChatException {
        List<AOutputMessage> outs = new ArrayList<AOutputMessage>();
        for (IHandleMessage handle : customs) {
            handle.onVoice(voice, outs);
        }
        sendMessage(outs, output, token);
    }

    private void handle(AInputMessageEvent event, OutputStream output, HandleToken token) throws IOException, WeChatException {
        List<AOutputMessage> outs = new ArrayList<AOutputMessage>();
        for (IHandleMessage handle : customs) {
            handle.onEvent(event, outs);
        }
        sendMessage(outs, output, token);
    }

    private void sendMessage(List<AOutputMessage> messages, OutputStream output, HandleToken token) throws IOException, WeChatException {
        if (isSingle(messages)) {
            sendSingle(messages.get(0), output);
        } else if (isMulti(messages)) {
            sendMulti(messages,output,token);
        } else {
            sendEmpty(output);
        }
    }

    private void sendEmpty(OutputStream out) throws IOException {
        out.write("".getBytes(CharsetUtils.UTF8));
    }

    private void sendMulti(List<AOutputMessage> msg, OutputStream out, HandleToken token) throws IOException, WeChatException {
        sendEmpty(out);
        if (token != null) {
            SendService service = SendService.valueOf(token);
            for (AOutputMessage m : msg) {
                service.send(m);
            }
        }
    }

    private void sendSingle(AOutputMessage msg, OutputStream out) throws IOException {
        String xml = OutputMessageFactory.getInstance().toXML(msg);
        out.write(xml.getBytes(CharsetUtils.UTF8));
    }

    private boolean isSingle(List<AOutputMessage> msg) {
        return !isEmpty(msg) && msg.size() == 1;
    }

    private boolean isMulti(List<AOutputMessage> msg) {
        return !isEmpty(msg) && msg.size() > 1;
    }

    private boolean isEmpty(List<AOutputMessage> msg) {
        return msg == null || msg.size() <= 0;
    }

}
