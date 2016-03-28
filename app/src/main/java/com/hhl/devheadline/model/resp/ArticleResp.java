package com.hhl.devheadline.model.resp;

import com.hhl.devheadline.model.Article;

import java.util.List;

/**
 * Created by HanHailong on 16/3/18.
 */
public class ArticleResp extends BaseResp {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * date : 2016-03-17
         * pre_date : 2016-03-16
         * next_date :
         * is_today : true
         * share_url : http://toutiao.io
         */

        private String date;
        private String pre_date;
        private String next_date;
        private boolean is_today;
        private String share_url;
        private List<Article> article;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPre_date() {
            return pre_date;
        }

        public void setPre_date(String pre_date) {
            this.pre_date = pre_date;
        }

        public String getNext_date() {
            return next_date;
        }

        public void setNext_date(String next_date) {
            this.next_date = next_date;
        }

        public boolean isIs_today() {
            return is_today;
        }

        public void setIs_today(boolean is_today) {
            this.is_today = is_today;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public List<Article> getArticle() {
            return article;
        }

        public void setArticle(List<Article> article) {
            this.article = article;
        }
    }
}
