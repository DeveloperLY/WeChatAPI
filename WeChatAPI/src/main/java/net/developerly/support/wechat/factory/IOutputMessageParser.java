package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.output.*;

/**
 * @author LY
 * @create 2017/06/04
 **/
public interface IOutputMessageParser {
    public String parser(OutputMessageVideo video);
    public String parser(OutputMessageVoice voice);
    public String parser(OutputMessageImage image);
    public String parser(OutputMessageMusic music);
    public String parser(OutputMessageNews news);
    public String parser(OutputMessageText text);
}
