package com.example.radiobutton_fragment;

import java.util.List;

public class MyGson_SH  {
    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-04-18 00:00","title":"鸿茅药酒案当事人妻子：感恩各界朋友 将举办记者会","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0418/B6DEFC597D95A4F042DFC48070E4A138507D0771_size21_w583_h327.jpeg","url":"http://news.ifeng.com/a/20180418/57669118_0.shtml"},{"ctime":"2018-04-18 00:00","title":"快递1个月还没寄到 邮政速递：快递员欠钱不还被抓了","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/a/2018_16/d9ea603ca30e47b_size43_w581_h304.jpg","url":"http://news.ifeng.com/a/20180418/57669472_0.shtml"},{"ctime":"2018-04-18 00:00","title":"多名为鸿茅药酒\u201c站台\u201d的专家 曾在鸿茅系公司任职","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0418/D34D76ED6744A5A53C9BB9D685F6A549DA96A2F0_size103_w600_h478.jpeg","url":"http://news.ifeng.com/a/20180418/57662761_0.shtml"},{"ctime":"2018-04-18 00:00","title":"女子遭校园霸凌9年后告赢施暴者：我的人生也不能重来","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0418/B6DEFC597D95A4F042DFC48070E4A138507D0771_size21_w583_h327.jpeg","url":"http://news.ifeng.com/a/20180418/57663303_0.shtml"},{"ctime":"2018-04-18 00:00","title":"山东男童坠入百米深井 15小时后被成功救出！","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/a/2018_16/3f911cc2bf736f0_size311_w525_h241.png","url":"http://news.ifeng.com/a/20180418/57659986_0.shtml"},{"ctime":"2018-04-18 00:00","title":"县城青年新认知：\u201c有能力\u201d比\u201c有关系\u201d更重要","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/a/2018_16/0846a4b32bd9f08_size21_w587_h164.png","url":"http://news.ifeng.com/a/20180418/57659453_0.shtml"},{"ctime":"2018-04-18 00:00","title":"江西上饶6名女童疑遭教师猥亵 一女童处女膜破裂","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/fck/2018_16/b94e06951edb10f_w500_h454.jpg","url":"http://news.ifeng.com/a/20180418/57657983_0.shtml"},{"ctime":"2018-04-18 00:00","title":"凉城公安局通报\u201c鸿茅药酒案\u201d","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/a/2018_16/0846a4b32bd9f08_size21_w587_h164.png","url":"http://news.ifeng.com/a/20180418/57658301_0.shtml"},{"ctime":"2018-04-17 00:00","title":"医生回家了，但鸿茅药酒违法这事怎么说？","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0417/44528D0C9AC91E5B6BBB4BF09F14033A9A1819AB_size24_w506_h284.jpeg","url":"http://news.ifeng.com/a/20180417/57657403_0.shtml"},{"ctime":"2018-04-17 00:00","title":"五问鸿茅药酒事件：警方是否有权跨省抓捕医生？","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/fck/2018_16/176575170431c6b_w300_h184.jpg","url":"http://news.ifeng.com/a/20180417/57657303_0.shtml"}]
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
         * ctime : 2018-04-18 00:00
         * title : 鸿茅药酒案当事人妻子：感恩各界朋友 将举办记者会
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0418/B6DEFC597D95A4F042DFC48070E4A138507D0771_size21_w583_h327.jpeg
         * url : http://news.ifeng.com/a/20180418/57669118_0.shtml
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
