package com.example.radiobutton_fragment;

import java.util.List;

/**
 * Created by John on 2018/4/18 0018.
 */

public class MyGson_YL {
    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-04-18 18:15","title":"《妖猫传》被指存在抄袭 陈凯歌被诉赔偿300万","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/7d2a1b7832f94e0bb0bcbe07530f259920180418181520.png_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/18/DFMODAML00038FO9.html"},{"ctime":"2018-04-18 18:17","title":"终于不是黑凤梨！邓紫棋手捧金凤梨调皮炫耀","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/b9f514b5633445e4b5165c59bd1f989120180418181711.png_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/18/DFMOHDMO00038FO9.html"},{"ctime":"2018-04-18 18:23","title":"周杰伦穿白衬衫晒上班照 遭网友调侃：他都变瘦了","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/b7c93ec9573d43bdbd1c88a17759bc2a20180418182306.jpeg_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/18/DFMOSDOH00038FO9.html"},{"ctime":"2018-04-18 17:27","title":"林俊杰坐行李箱上晒自拍 打扮超酷搭配有型很吸睛","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/13e570ef8e774d8d850245e44a90596b20180418172701.png_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/17/DFMLL1DU00038FO9.html"},{"ctime":"2018-04-18 17:29","title":"港片没落 金像奖的含金量还剩多少？","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/88943e6172d941d084383a3c179091a720180418171327.jpeg_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/17/DFMLOM1I00039840.html"},{"ctime":"2018-04-18 17:30","title":"何炅素颜自拍气色好 调侃\u201c手机到手话痨回来了\u201d","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/3aae40272d1c4c5cb106150281c99e5d20180418173023.png_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/17/DFMLRE8100038FO9.html"},{"ctime":"2018-04-18 17:44","title":"靳东妻子李佳产后学瑜伽 自我调侃是\u201c胖子\u201d","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/088e7b84950d4790a338f9a8eb61076120180418174258.png_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/17/DFMMK74L00038FO9.html"},{"ctime":"2018-04-18 17:47","title":"黄晓明发文为徐峥庆生 语言谦虚态度暖心友谊满满","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/6666b84477c445e584eae88104987eab20180418174730.png_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/17/DFMMQ9R900038FO9.html"},{"ctime":"2018-04-18 15:44","title":"社会我爽姐的性格有人敢性侵？造谣者低估了郑爽的任性和陈导的审美","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/42e098fc97544af4841ce74ac586ce7520180418153718.jpeg_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/15/DFMFPR5M00039867.html"},{"ctime":"2018-04-18 16:12","title":"网友梵蒂冈偶遇王大陆姜汉娜 二人同游恋情疑曝光","description":"网易明星","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/20e718f09afa4aa998a80c53cf6cbbd520180418161213.png_130x90x1x85.jpg","url":"http://ent.163.com/18/0418/16/DFMHC0Q200038FO9.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2018-04-18 18:15
         * title : 《妖猫传》被指存在抄袭 陈凯歌被诉赔偿300万
         * description : 网易明星
         * picUrl : http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/7d2a1b7832f94e0bb0bcbe07530f259920180418181520.png_130x90x1x85.jpg
         * url : http://ent.163.com/18/0418/18/DFMODAML00038FO9.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
