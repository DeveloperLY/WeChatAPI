package net.developerly.support.wechat.cgi;

import net.developerly.support.wechat.utils.HTTPUtils;
import net.developerly.support.wechat.utils.JsonUtils;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LY
 * @create 2017/06/03
 **/
public class HandleMedia {
//	private static final String URL="http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
//	图片（image）: 1M，支持JPG格式
//	语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
//	视频（video）：10MB，支持MP4格式
//	缩略图（thumb）：64KB，支持JPG格式
//	private static final String URL="http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
// https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN
// https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN
//

    private static final String GET_URL             = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%1$s&media_id=%2$s";
    private static final String UPLOAD_URL          = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=%1$s&type=%2$s";

    private static final String UPLOAD_NEWS_URL     = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=%1$s";
    private static final String UPLOAD_VIDEO_URL    = "https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=%1$s";

    private String access_token;

    private HandleMedia() {
        super();
    }

    private HandleMedia(String access_token) {
        super();
        this.access_token = access_token;
    }

    public static HandleMedia valueOf(String access_token) {
        return new HandleMedia(access_token);
    }

    public void getMedia(String media_id, OutputStream out) {
        String url = String.format(GET_URL, access_token,media_id);
        byte[] datas = HTTPUtils.get(url);
        // TODO 下载图片、语音、视频、缩略图数据.或者是错误JSON数据
    }

    public void uploadMedia(String media_type, byte[] media_datas) {
        String url = String.format(UPLOAD_URL, access_token,media_type);
        byte[] datas = HTTPUtils.post(url, media_datas);
        // TODO 返回状态信息或上传后的基本信息

    }

    public void uploadSendGroupNews(News news) {
        String url = String.format(UPLOAD_NEWS_URL, access_token);
        byte[] datas = HTTPUtils.postOfSSL(url, JsonUtils.toJsonStr(news));
        // TODO 处理返回信息：状态信息、图文信息
    }

    public void uploadSendGroupVideo(String media_id, String title, String description) {
        String url = String.format(UPLOAD_VIDEO_URL, access_token);
        Map<String, String> video = new HashMap<String, String>();
        video.put("media_id", media_id);
        video.put("title", title);
        video.put("description", description);
        byte[] datas = HTTPUtils.postOfSSL(url, JsonUtils.toJsonStr(video));
        // TODO 处理返回信息：状态信息、上传后媒体信息
    }


    public class News {
        private List<Article> articles = new ArrayList<Article>();

        public void addArticle(Article article) {
            removeFirst();
            this.articles.add(article);
        }

        public void clear() {
            articles.clear();
        }

        public List<Article> getArticles() {
            List<Article> list = new ArrayList<Article>();
            list.addAll(articles);
            return list;
        }

        public boolean isMax() {
            return articles.size() >= 10;
        }

        private void removeFirst() {
            if(isMax()) {
                articles = articles.subList(articles.size() - 9, articles.size());
            }
        }
    }

    public class Article {
        private String thumb_media_id;
        private String author;
        private String title;
        private String content_source_url;
        private String content;
        private String digest;
        private String show_cover_pic;

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent_source_url() {
            return content_source_url;
        }

        public void setContent_source_url(String content_source_url) {
            this.content_source_url = content_source_url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getShow_cover_pic() {
            return show_cover_pic;
        }

        public void setShow_cover_pic(String show_cover_pic) {
            this.show_cover_pic = show_cover_pic;
        }

    }
}
