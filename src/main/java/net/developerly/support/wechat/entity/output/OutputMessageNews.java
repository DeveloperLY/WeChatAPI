package net.developerly.support.wechat.entity.output;

import net.developerly.support.wechat.type.MessageType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 回复图文消息
 *
 * @author LY
 * @create 2017/06/02
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputMessageNews extends AOutputMessage {

    @XmlElement(name="ArticleCount")
    private int articleCount;

    @XmlElementWrapper(name="Articles")
    @XmlElement(name="item")
    private List<Item> articles = new ArrayList<Item>();

    private OutputMessageNews() {

    };

    /**
     * 获得多图文消息
     * @param toUserName
     * 			关注者ID
     * @param fromUserName
     * 			公众号ID
     * @return
     */
    public static OutputMessageNews valueOf(String toUserName, String fromUserName) {
        OutputMessageNews news = new OutputMessageNews();
        news.setCreateTime(new Date().getTime());
        news.setFromUserName(fromUserName);
        news.setMsgType(MessageType.NEWS.getKey());
        news.setToUserName(toUserName);
        return news;
    }

    private void addItem(Item item) {
        articles.add(item);
        articleCount++;
    }

    /**
     * 添加多图文内容
     * @param title
     * 			标题
     * @param description
     * 			描述
     * @param picUrl
     * 			图片URL
     * @param url
     * 			访问URL
     */
    public void addItem(String title, String description, String picUrl, String url){
        Item item = new Item();
        item.setDescription(description);
        item.setPicUrl(picUrl);
        item.setTitle(title);
        item.setUrl(url);
        addItem(item);
    }

    public void removeAllItem() {
        articles.clear();
        articleCount=0;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public List<OutputMessageNews.Item> getArticles() {
        //TODO 此处应使用复制
        List<Item> list = new ArrayList<Item>();
        list.addAll(articles);
        return list;
    }

    @XmlRootElement(name="item")
    public static class Item {
        private String title;
        private String description;
        private String picUrl;
        private String url;

        @XmlElement(name="Title")
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        @XmlElement(name="Description")
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @XmlElement(name="PicUrl")
        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        @XmlElement(name="Url")
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
