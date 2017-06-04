package net.developerly.support.wechat.factory;

import net.developerly.support.wechat.entity.output.*;
import net.developerly.support.wechat.type.MessageType;
import net.developerly.support.wechat.utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LY
 * @create 2017/06/04
 **/
public class OutputMessageParserToJSONAdapter implements IOutputMessageParser {

    @Override
    public String parser(OutputMessageVideo video) {
        Map<String, Object> template = createTemplate(MessageType.VIDEO, video.getToUserName());
        Map<String, Object> media = (Map<String, Object>)template.get(MessageType.VIDEO.getKey());
        media.put("media_id", video.getMediaId());
        media.put("thumb_media_id", video.getMediaId());
        media.put("title", video.getTitle());
        media.put("description", video.getDescription());
        return JsonUtils.toJsonStr(template);
    }

    @Override
    public String parser(OutputMessageVoice voice) {
        Map<String, Object> template = createTemplate(MessageType.VOICE, voice.getToUserName());
        Map<String, Object> media = (Map<String, Object>)template.get(MessageType.VOICE.getKey());
        media.put("media_id", voice.getMediaId());
        return JsonUtils.toJsonStr(template);
    }

    @Override
    public String parser(OutputMessageImage image) {
        Map<String, Object> template = createTemplate(MessageType.IMAGE, image.getToUserName());
        Map<String, Object> media = (Map<String, Object>)template.get(MessageType.IMAGE.getKey());
        media.put("media_id", image.getMediaId());
        return JsonUtils.toJsonStr(template);
    }

    @Override
    public String parser(OutputMessageMusic music) {
        Map<String, Object> template = createTemplate(MessageType.MUSIC, music.getToUserName());
        Map<String, Object> media = (Map<String, Object>)template.get(MessageType.MUSIC.getKey());
        media.put("title", music.getTitle());
        media.put("description", music.getDescription());
        media.put("musicurl", music.getMusicURL());
        media.put("hqmusicurl", music.getHqMusicUrl());
        media.put("thumb_media_id", music.getThumbMediaId());
        return JsonUtils.toJsonStr(template);
    }

    @Override
    public String parser(OutputMessageNews news) {
        Map<String, Object> template = createTemplate(MessageType.NEWS, news.getToUserName());
        Map<String, Object> media = (Map<String, Object>)template.get(MessageType.NEWS.getKey());
        List<Map<String, String>> articles = new ArrayList<Map<String,String>>();
        for (OutputMessageNews.Item item : news.getArticles()) {
            Map<String, String> article = new HashMap<String, String>();
            article.put("title", item.getTitle());
            article.put("description", item.getDescription());
            article.put("url", item.getUrl());
            article.put("picurl", item.getPicUrl());
            articles.add(article);
        }
        media.put("Articles", articles);
        return JsonUtils.toJsonStr(template);
    }

    @Override
    public String parser(OutputMessageText text) {
        Map<String, Object> template = createTemplate(MessageType.TEXT, text.getToUserName());
        Map<String, Object> content = (Map<String, Object>)template.get(MessageType.TEXT.getKey());
        content.put("content", text.getContent());
        return JsonUtils.toJsonStr(template);
    }

    private Map<String, Object> createTemplate(MessageType type, String toUserOpenid) {
        Map<String, Object> template = new HashMap<String, Object>();
        template.put("touser", toUserOpenid);
        template.put("msgtype", type.getKey());
        template.put(type.getKey(), new HashMap<String, Object>());
        return template;
    }
}
