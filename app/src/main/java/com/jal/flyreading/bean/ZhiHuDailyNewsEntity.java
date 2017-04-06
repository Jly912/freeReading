package com.jal.flyreading.bean;

import java.util.List;

/**
 * Created by SEELE on 2017/4/6.
 * 知乎最新消息
 */

public class ZhiHuDailyNewsEntity {

    /**
     * date : 20170406
     * stories : [{"images":["https://pic1.zhimg.com/v2-94fc66ae23ae8d536e0786339f05f554.jpg"],"type":0,"id":9329517,"ga_prefix":"040610","title":"怎么到现在还有人相信「全国每年 210 万儿童死于装修」？"},{"images":["https://pic1.zhimg.com/v2-a019695d89d8d30b65b9dbbc2bd78c18.jpg"],"type":0,"id":9338925,"ga_prefix":"040609","title":"猫主子根本不会「妒忌」，你想多了哼哼"},{"title":"全球只有 7 人完成过，这是比攀登珠峰更令人惊叹的探险","ga_prefix":"040608","images":["https://pic2.zhimg.com/v2-a28fc4ec2c6e2f9480cededf698ad5cd.jpg"],"multipic":true,"type":0,"id":9338552},{"images":["https://pic3.zhimg.com/v2-ceeb67df90f5f2d19ca4c7a38a574022.jpg"],"type":0,"id":9338554,"ga_prefix":"040607","title":"你看，那个人在对着一只牛研究大象和老鼠"},{"images":["https://pic2.zhimg.com/v2-8fe914d7c0392ec7d3bbd4e05253afd5.jpg"],"type":0,"id":9338357,"ga_prefix":"040607","title":"马云常说的「新零售」会带来哪些新的机会？"},{"images":["https://pic1.zhimg.com/v2-843ddbf533365695fe11322ff98eb700.jpg"],"type":0,"id":9338342,"ga_prefix":"040607","title":"人工智能背后，有人在默默做着机械而繁重的工作"},{"images":["https://pic2.zhimg.com/v2-590b9487c043505e9e60d6af74e2039d.jpg"],"type":0,"id":9336381,"ga_prefix":"040606","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-87c968324465e4bfab1495162bed1af2.jpg","type":0,"id":9338552,"ga_prefix":"040608","title":"全球只有 7 人完成过，这是比攀登珠峰更令人惊叹的探险"},{"image":"https://pic3.zhimg.com/v2-b5f946e6b4ef368aa965d9391802c2b2.jpg","type":0,"id":9338357,"ga_prefix":"040607","title":"马云常说的「新零售」会带来哪些新的机会？"},{"image":"https://pic4.zhimg.com/v2-894de8db5d54b8c4646cbb003dc8c71b.jpg","type":0,"id":9338342,"ga_prefix":"040607","title":"人工智能背后，有人在默默做着机械而繁重的工作"},{"image":"https://pic2.zhimg.com/v2-3a1501f45065638d15d2755ef3dc8b6d.jpg","type":0,"id":9337665,"ga_prefix":"040516","title":"这场 Dota 决赛还没正式开打，IG 就「赢了一半」"},{"image":"https://pic3.zhimg.com/v2-ef383b663681ffc3b7e9f77b847c18aa.jpg","type":0,"id":9337365,"ga_prefix":"040514","title":"这里有一块空白的画布，我们邀请所有人一起来创作"}]
     */

    private String date;
    private List<StoriesBean> stories;//当日新闻
    private List<TopStoriesBean> top_stories;

    @Override
    public String toString() {
        return "ZhiHuDailyNewsEntity{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-94fc66ae23ae8d536e0786339f05f554.jpg"]
         * type : 0
         * id : 9329517
         * ga_prefix : 040610
         * title : 怎么到现在还有人相信「全国每年 210 万儿童死于装修」？
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        @Override
        public String toString() {
            return "StoriesBean{" +
                    "type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    ", multipic=" + multipic +
                    ", images=" + images +
                    '}';
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic3.zhimg.com/v2-87c968324465e4bfab1495162bed1af2.jpg
         * type : 0
         * id : 9338552
         * ga_prefix : 040608
         * title : 全球只有 7 人完成过，这是比攀登珠峰更令人惊叹的探险
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        @Override
        public String toString() {
            return "TopStoriesBean{" +
                    "image='" + image + '\'' +
                    ", type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
