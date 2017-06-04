package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.input.AInputMessageEvent;
import net.developerly.support.wechat.entity.input.InputMessageUnknow;
import net.developerly.support.wechat.entity.input.base.*;
import net.developerly.support.wechat.entity.output.AOutputMessage;
import net.developerly.support.wechat.entity.output.OutputMessageText;

import java.util.List;

/**
 * 默认微信消息处理
 *
 * @author LY
 * @create 2017/06/04
 **/
public class HandleMessageAdapter implements IHandleMessage {

    @Override
    public void onText(InputMessageText text, List<AOutputMessage> outputs) {
        OutputMessageText welcome = OutputMessageText.valueOf(text.getFromUserName(), text.getToUserName(), "Welcome to the DeveloperLY Partner WeChat !!");
        OutputMessageText address = OutputMessageText.valueOf(text.getFromUserName(), text.getToUserName(), "Address:广东省深圳市南山区");
        OutputMessageText tel = OutputMessageText.valueOf(text.getFromUserName(), text.getToUserName(), "Tel:135****1658");
        OutputMessageText qq = OutputMessageText.valueOf(text.getFromUserName(), text.getToUserName(), "QQ:379509684");
        OutputMessageText email = OutputMessageText.valueOf(text.getFromUserName(), text.getToUserName(), "E-mail:coderyliu@gmail.com");
        outputs.add(welcome);
        outputs.add(address);
        outputs.add(tel);
        outputs.add(qq);
        outputs.add(email);
    }

    @Override
    public void onImage(InputMessageImage image, List<AOutputMessage> outputs) {
        OutputMessageText out = OutputMessageText.valueOf(image.getFromUserName(), image.getToUserName(), "Welcome to the DeveloperLY Partner WeChat !!");
        outputs.add(out);
    }

    @Override
    public void onEvent(AInputMessageEvent event, List<AOutputMessage> outputs) {
        OutputMessageText out = OutputMessageText.valueOf(event.getFromUserName(), event.getToUserName(), "Welcome to the DeveloperLY Partner WeChat !!");
        outputs.add(out);
    }

    @Override
    public void onLink(InputMessageLink link, List<AOutputMessage> outputs) {
        OutputMessageText out = OutputMessageText.valueOf(link.getFromUserName(), link.getToUserName(), "Welcome to the DeveloperLY Partner WeChat !!");
        outputs.add(out);
    }

    @Override
    public void onLocation(InputMessageLocation location, List<AOutputMessage> outputs) {
        OutputMessageText out = OutputMessageText.valueOf(location.getFromUserName(), location.getToUserName(), "Welcome to the DeveloperLY Partner WeChat !!");
        outputs.add(out);
    }

    @Override
    public void onVoice(InputMessageVoice voice, List<AOutputMessage> outputs) {
        OutputMessageText out = OutputMessageText.valueOf(voice.getFromUserName(), voice.getToUserName(), "Welcome to the DeveloperLY Partner WeChat !!");
        outputs.add(out);
    }

    @Override
    public void onVideo(InputMessageVideo video, List<AOutputMessage> outputs) {
        OutputMessageText out = OutputMessageText.valueOf(video.getFromUserName(), video.getToUserName(), "Welcome to the DeveloperLY Partner WeChat !!");
        outputs.add(out);
    }

    @Override
    public void onOther(InputMessageUnknow other, List<AOutputMessage> outputs) {
        OutputMessageText out = OutputMessageText.valueOf(other.getFromUserName(), other.getToUserName(), "Welcome to the DeveloperLY Partner WeChat !!");
        outputs.add(out);
    }


}
