package com.hhl.devheadline.model;

/**
 * Created by HanHailong on 16/3/18.
 */
public class Article {

    /**
     * is_advertorial : false
     * id : 294078
     * title : 如果你用 GitHub，可以这样提高效率
     * contributor : 流星狂飙
     * original_site_name : segmentfault.com
     * is_recommend : false
     * original_url : http://toutiao.io/r/0ivkig
     * image : null
     * thumbnail :
     * is_featured : true
     * comment_count : 2
     * like_count : 109
     * liked : false
     * subject : {"id":22029,"name":"魅族科技开发团队","image":"http://7rf34y.com1.z0.glb.clouddn.com/subject/b79abfd1238f420eadbb38ba69421759/thumb"}
     * user : {"id":"145451","name":"流星狂飙","avatar":"http://7rf34y.com1.z0.glb.clouddn.com/user/a6597eea1e2e4573aba796c98e396754/thumb","bio":null,"following":false}
     * author_info : {"name":"JerryC","url":""}
     * created_at : 1458124470
     */

    private boolean is_advertorial;
    private int id;
    private String title;
    private String contributor;
    private String original_site_name;
    private boolean is_recommend;
    private String original_url;
    private Object image;
    private String thumbnail;
    private boolean is_featured;
    private int comment_count;
    private int like_count;
    private boolean liked;
    /**
     * id : 22029
     * name : 魅族科技开发团队
     * image : http://7rf34y.com1.z0.glb.clouddn.com/subject/b79abfd1238f420eadbb38ba69421759/thumb
     */

    private SubjectBean subject;
    /**
     * id : 145451
     * name : 流星狂飙
     * avatar : http://7rf34y.com1.z0.glb.clouddn.com/user/a6597eea1e2e4573aba796c98e396754/thumb
     * bio : null
     * following : false
     */

    private UserBean user;
    /**
     * name : JerryC
     * url :
     */

    private AuthorInfoBean author_info;
    private int created_at;

    public boolean isIs_advertorial() {
        return is_advertorial;
    }

    public void setIs_advertorial(boolean is_advertorial) {
        this.is_advertorial = is_advertorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getOriginal_site_name() {
        return original_site_name;
    }

    public void setOriginal_site_name(String original_site_name) {
        this.original_site_name = original_site_name;
    }

    public boolean isIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(boolean is_recommend) {
        this.is_recommend = is_recommend;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isIs_featured() {
        return is_featured;
    }

    public void setIs_featured(boolean is_featured) {
        this.is_featured = is_featured;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public SubjectBean getSubject() {
        return subject;
    }

    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public AuthorInfoBean getAuthor_info() {
        return author_info;
    }

    public void setAuthor_info(AuthorInfoBean author_info) {
        this.author_info = author_info;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public static class SubjectBean {
        private int id;
        private String name;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class UserBean {
        private String id;
        private String name;
        private String avatar;
        private Object bio;
        private boolean following;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Object getBio() {
            return bio;
        }

        public void setBio(Object bio) {
            this.bio = bio;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }
    }

    public static class AuthorInfoBean {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
