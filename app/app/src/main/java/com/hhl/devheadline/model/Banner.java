package com.hhl.devheadline.model;

/**
 * Created by HanHailong on 16/3/16.
 */
public class Banner {

    /**
     * content_type : article
     * ad_id : 0
     * title : 程序员如何优雅地挣零花钱？
     * image : http://7rf34y.com1.z0.glb.clouddn.com/post%2F14448688e2474ef09d49af67aac45042
     * article : {"id":288872}
     * webpage : null
     */

    private String content_type;
    private int ad_id;
    private String title;
    private String image;
    /**
     * id : 288872
     */

    private ArticleBean article;
    private String webpage;

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public static class ArticleBean {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
